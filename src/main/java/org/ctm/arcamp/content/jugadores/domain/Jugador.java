package org.ctm.arcamp.content.jugadores.domain;

import io.quarkus.arc.All;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.shared.enums.EstiloJuego;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    private Long id;
    private String nombre;
    private String apellidos;
    private Boolean diestro;
    private LocalDate fechaNacimiento;
    private Double porcentajeVictorias;
    private EstiloJuego estiloJuego;
    private Long clubId;
}
