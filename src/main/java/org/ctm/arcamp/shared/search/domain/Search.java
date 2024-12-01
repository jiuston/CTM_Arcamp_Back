package org.ctm.arcamp.shared.search.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.SortDirection;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Search {

    private List<Filter> filters;
    private String sortField;
    private SortDirection sortDirection;
    private int page;
    private int size;
}
