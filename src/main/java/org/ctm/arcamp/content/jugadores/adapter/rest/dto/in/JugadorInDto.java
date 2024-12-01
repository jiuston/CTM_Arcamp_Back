package org.ctm.arcamp.content.jugadores.adapter.rest.dto.in;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.shared.enums.EstiloJuego;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorInDto {

    private String nombre;
    private String apellidos;
    private Boolean diestro;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private EstiloJuego estiloJuego;
    private String comentarios;
    private Long clubId;

}
