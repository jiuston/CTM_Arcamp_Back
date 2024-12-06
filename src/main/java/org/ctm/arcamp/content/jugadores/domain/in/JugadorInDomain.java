package org.ctm.arcamp.content.jugadores.domain.in;

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
public class JugadorInDomain extends Jugador {
    private Boolean diestro;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private EstiloJuego estiloJuego;
    private String comentarios;
}
