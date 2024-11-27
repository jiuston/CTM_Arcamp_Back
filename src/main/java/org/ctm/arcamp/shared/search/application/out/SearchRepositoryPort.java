package org.ctm.arcamp.shared.search.application.out;

import org.ctm.arcamp.shared.search.domain.Filter;

import java.util.List;

public interface SearchRepositoryPort {
    <T> List<T> search(List<Filter> filters, Class<T> entityClass);
}
