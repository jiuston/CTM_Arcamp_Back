package org.ctm.arcamp.shared.search.domain;


public enum LogicalOperator {
    AND, OR;

    public static LogicalOperator valueOfString(String logicalOperator) {
        return LogicalOperator.valueOf(logicalOperator.toUpperCase());
    }
}
