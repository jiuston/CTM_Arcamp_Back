package org.ctm.arcamp.content.jugadores.adapter.rest.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.Getter;
import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.shared.search.application.out.SearchRepositoryPort;
import org.ctm.arcamp.shared.search.domain.Filter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.annotations.Param;

import java.util.List;

@ApplicationScoped
@Path("jugadores")
public class JugadoresController {

    @Inject
    SearchRepositoryPort searchRepositoryPort;

    @POST
    @Path("search")
    public List<JugadorEntity> search(@RequestBody List<Filter> search) {
        return searchRepositoryPort.search(search, JugadorEntity.class);
    }
}
