package org.ctm.arcamp.shared.search.adapter.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.ctm.arcamp.shared.search.application.out.SearchRepositoryPort;
import org.ctm.arcamp.shared.search.domain.CustomPage;
import org.ctm.arcamp.shared.search.domain.Filter;
import org.ctm.arcamp.shared.search.domain.Search;
import org.hibernate.query.SortDirection;

import java.util.Date;
import java.util.List;

import static org.ctm.arcamp.shared.search.domain.LogicalOperator.AND;
import static org.hibernate.query.SortDirection.DESCENDING;

@ApplicationScoped
public class SearchRepository implements SearchRepositoryPort {
    @Inject
    EntityManager entityManager;

    @Override
    public <T> CustomPage<T> search(Search search, Class<T> entityClass) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        Predicate predicate = applyFilters(search, cb, root, query);
        SortDirection sortDirection = search.getSortDirection();
        if (sortDirection.equals(DESCENDING))
            query.orderBy(cb.desc(root.get(search.getSortField())));
        else
            query.orderBy(cb.asc(root.get(search.getSortField())));
        TypedQuery<T> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(search.getPage() * search.getSize());
        typedQuery.setMaxResults(search.getSize());
        List<T> content = typedQuery.getResultList();

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<T> countFrom = countQuery.from(entityClass);
        countQuery.select(cb.count(countFrom));
        countQuery.where(predicate);
        long totalElements = entityManager.createQuery(countQuery).getSingleResult();
        int totalPages = (int) Math.ceil((double) totalElements / search.getSize());
        return new CustomPage<>(content, search.getPage(), search.getSize(), totalElements, totalPages);
    }

    private <T> Predicate applyFilters(Search search, CriteriaBuilder cb, Root<T> root, CriteriaQuery<T> query) {
        if (search.getFilters()!=null && !search.getFilters().isEmpty()){
            List<Filter> filters = search.getFilters();
            Predicate combinedPredicate = buildCombinedPredicate(filters, cb, root);
            query.where(combinedPredicate);
            return combinedPredicate;
        }
        return cb.conjunction();
    }

    private Predicate buildCombinedPredicate(List<Filter> filters, CriteriaBuilder cb, Root<?> root) {
        Predicate combinedPredicate = null;
        for (Filter filter : filters) {
            if (combinedPredicate == null) combinedPredicate = buildPredicate(filter, cb, root);
            else {
                if (filter.getLogicalOperator() == null || filter.getLogicalOperator().equals(AND)){
                    combinedPredicate = cb.and(combinedPredicate, buildPredicate(filter, cb, root));
                } else{
                    combinedPredicate = cb.or(combinedPredicate, buildPredicate(filter, cb, root));
                }
            }
        }
        return combinedPredicate;
    }

    private Predicate buildPredicate(Filter filter, CriteriaBuilder cb, Root<?> root) {
        Object value = filter.getValue();
        switch (filter.getOperator()) {
            case EQUALS: return cb.equal(root.get(filter.getField()), value);
            case NOT_EQUALS: return cb.notEqual(root.get(filter.getField()), value);
            case LIKE: return cb.like(root.get(filter.getField()), "%" + value + "%");
            case NOT_LIKE: return cb.notLike(root.get(filter.getField()), "%" + value + "%");
            case GREATER_THAN: {
                if (value instanceof Number) {
                    return cb.gt(root.get(filter.getField()), (Number) value);
                } else if (value instanceof Date) {
                    return cb.greaterThan(root.get(filter.getField()), (Date) value);
                } else {
                    throw new IllegalArgumentException("Tipo de dato no soportado para operador 'Mayor que'");
                }
            }
            case GREATER_EQUALS: {
                if (value instanceof Number){
                    return cb.ge(root.get(filter.getField()), (Number) value);
                } else if (value instanceof Date){
                    return cb.greaterThanOrEqualTo(root.get(filter.getField()), (Date) value);
                } else {
                    throw new IllegalArgumentException("Tipo de dato no soportado para operador 'Mayor o igual que'");
                }
            }
            case LESS_THAN: {
                if (value instanceof Number){
                    return cb.lt(root.get(filter.getField()), (Number) value);
                } else if (value instanceof Date){
                    return cb.lessThan(root.get(filter.getField()), (Date) value);
                } else {
                    throw new IllegalArgumentException("Tipo de dato no soportado para operador 'Menor que'");
                }
            }
            case LESS_EQUALS: {
                if (value instanceof Number){
                    return cb.le(root.get(filter.getField()), (Number) value);
                } else if (value instanceof Date){
                    return cb.lessThanOrEqualTo(root.get(filter.getField()), (Date) value);
                } else {
                    throw new IllegalArgumentException("Tipo de dato no soportado para operador 'Menor o igual que'");
                }
            }
            // Agrega más casos según sea necesario
            default: throw new IllegalArgumentException("Operador no soportado: " + filter.getOperator());
        }
    }

}
