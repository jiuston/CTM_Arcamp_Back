package org.ctm.arcamp.content.jugadores.adapter.rest.mapper;

import org.ctm.arcamp.content.jugadores.adapter.rest.dto.in.JugadorInDto;
import org.ctm.arcamp.content.jugadores.adapter.rest.dto.out.JugadorOutDto;
import org.ctm.arcamp.content.jugadores.adapter.rest.dto.out.JugadorTableOutDto;
import org.ctm.arcamp.content.jugadores.domain.Jugador;
import org.ctm.arcamp.content.jugadores.domain.in.JugadorInDomain;
import org.ctm.arcamp.content.jugadores.domain.out.JugadorOutDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface JugadorDtoMapper {

    default JugadorOutDto toOutDto(Jugador domain){
        if (domain instanceof JugadorOutDomain){
            return toTableOutDto((JugadorOutDomain) domain);
        }
        return null;
    }

    JugadorTableOutDto toTableOutDto(JugadorOutDomain jugador);

    JugadorInDomain toInDomain(JugadorInDto jugador);

    default JugadorInDomain toInDomain(Long id, JugadorInDto jugador){
        JugadorInDomain domain = toInDomain(jugador);
        domain.setId(id);
        return domain;
    }
}
