package org.ctm.arcamp.shared.search.domain;

import io.quarkus.arc.All;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomPage<T> {

    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

}
