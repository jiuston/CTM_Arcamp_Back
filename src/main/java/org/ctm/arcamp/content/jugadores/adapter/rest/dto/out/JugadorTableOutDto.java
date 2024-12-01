package org.ctm.arcamp.content.jugadores.adapter.rest.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.shared.enums.EstiloJuego;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorTableOutDto extends JugadorOutDto{
    private String nombre;
    private String apellidos;
    private Boolean diestro;
    private Double porcentajeVictorias;
    private Integer edad;
    private EstiloJuego estiloJuego;
}
