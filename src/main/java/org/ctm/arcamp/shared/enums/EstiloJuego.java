package org.ctm.arcamp.shared.enums;

import java.util.Arrays;

public enum EstiloJuego {

    AGRESIVO,
    DEFENSIVO,
    NEUTRO;

    public static EstiloJuego valueOfString(String estiloJuego) {
        return EstiloJuego.valueOf(estiloJuego.toUpperCase());
    }
}
