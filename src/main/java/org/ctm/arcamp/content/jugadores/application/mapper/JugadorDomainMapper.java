package org.ctm.arcamp.content.jugadores.application.mapper;

import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.content.jugadores.domain.Jugador;
import org.ctm.arcamp.content.jugadores.domain.in.JugadorInDomain;
import org.ctm.arcamp.content.jugadores.domain.out.JugadorOutDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface JugadorDomainMapper {

    Jugador toDomain(JugadorEntity jugador);

    JugadorOutDomain toOutDomain(JugadorEntity jugador);

    JugadorEntity toEntity(Jugador jugador);

    @Mapping(target = "porcentajeVictorias", ignore = true)
    void update(Jugador jugador, @MappingTarget JugadorEntity existingJugador);
}
