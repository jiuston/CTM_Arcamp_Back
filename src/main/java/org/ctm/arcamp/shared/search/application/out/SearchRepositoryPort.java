package org.ctm.arcamp.shared.search.application.out;

import org.ctm.arcamp.shared.search.domain.Filter;
import org.ctm.arcamp.shared.search.domain.Search;

import java.util.List;

public interface SearchRepositoryPort {
    <T> List<T> search(Search search, Class<T> entityClass);
}
