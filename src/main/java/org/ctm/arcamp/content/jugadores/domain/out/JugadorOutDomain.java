package org.ctm.arcamp.content.jugadores.domain.out;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.content.jugadores.domain.Jugador;
import org.ctm.arcamp.shared.enums.EstiloJuego;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorOutDomain extends Jugador {
    private Boolean diestro;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    private Double porcentajeVictorias;
    private EstiloJuego estiloJuego;
    private Integer edad;
}
