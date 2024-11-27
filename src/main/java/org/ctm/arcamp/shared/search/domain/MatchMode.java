package org.ctm.arcamp.shared.search.domain;

public enum MatchMode {
    EQUALS,
    NOT_EQUALS,
    GREATER_THAN,
    GREATER_EQUALS,
    LESS_THAN,
    LESS_EQUALS,
    LIKE,
    NOT_LIKE,
    STARTS_WITH,
    ENDS_WITH,
    IN,
    NOT_IN,
    IS_NULL,
    IS_NOT_NULL;

    public static MatchMode valueOfString(String matchMode) {
        return MatchMode.valueOf(matchMode.toUpperCase());
    }
}
