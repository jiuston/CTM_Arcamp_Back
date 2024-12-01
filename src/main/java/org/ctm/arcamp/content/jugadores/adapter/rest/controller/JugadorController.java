package org.ctm.arcamp.content.jugadores.adapter.rest.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.ctm.arcamp.content.jugadores.adapter.rest.dto.in.JugadorInDto;
import org.ctm.arcamp.content.jugadores.adapter.rest.dto.out.JugadorOutDto;
import org.ctm.arcamp.content.jugadores.adapter.rest.mapper.JugadorDtoMapper;
import org.ctm.arcamp.content.jugadores.application.in.JugadorPort;
import org.ctm.arcamp.content.jugadores.domain.Jugador;
import org.ctm.arcamp.content.jugadores.domain.out.JugadorOutDomain;
import org.ctm.arcamp.shared.search.domain.Filter;
import org.ctm.arcamp.shared.search.domain.Search;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.hibernate.query.SortDirection;
import org.jboss.logging.annotations.Param;

import java.util.List;

@ApplicationScoped
@Path("jugadores")
public class JugadorController {

    @Inject
    JugadorPort jugadorPort;

    @Inject
    JugadorDtoMapper mapper;

    @GET
    @Path("{id}")
    public JugadorOutDto get(@PathParam("id") Long id) {
        return mapper.toOutDto(jugadorPort.get(id));
    }

    @POST
    public JugadorOutDto create(@RequestBody JugadorInDto jugador){
        return mapper.toOutDto(jugadorPort.create(mapper.toInDomain(jugador)));
    }

    @PUT
    @Path("{id}")
    public JugadorOutDto update(@PathParam("id") Long id, @RequestBody JugadorInDto jugador){
        return mapper.toOutDto(jugadorPort.update(mapper.toInDomain(id, jugador)));
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        jugadorPort.delete(id);
    }

    @POST
    @Path("search")
    public List<JugadorOutDto> search(@RequestBody List<Filter> filters, @QueryParam("page") @DefaultValue("0") int page, @QueryParam("size") @DefaultValue("10") int size, @QueryParam("sortField") @DefaultValue("id") String sortField, @QueryParam("sortDirection") @DefaultValue("ASCENDING") SortDirection sortDirection){
        List<JugadorOutDomain> jugadores = jugadorPort.search(new Search(filters, sortField, sortDirection, page, size));
        return jugadores.stream().map(mapper::toOutDto).toList();
    }
}
