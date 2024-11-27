package org.ctm.arcamp.shared.search.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filter {
    private String field;                    // Nombre del campo
    private MatchMode operator;              // Operador (EQUALS, NOT_EQUALS, LIKE, etc.)
    private Object value;                    // Valor del filtro
    private LogicalOperator logicalOperator; // AND o OR

}
