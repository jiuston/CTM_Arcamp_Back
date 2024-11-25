package org.ctm.arcamp.shared.enums;

public enum TipoPartido {

    ENTRENAMIENTO,
    AMISTOSO,
    COMPETITIVO;

    public static TipoPartido valueOfString(String tipoPartido) {
        return TipoPartido.valueOf(tipoPartido.toUpperCase());
    }

}
