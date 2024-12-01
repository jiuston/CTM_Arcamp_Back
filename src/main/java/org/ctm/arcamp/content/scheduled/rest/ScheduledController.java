package org.ctm.arcamp.content.scheduled.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.ctm.arcamp.content.scheduled.port.JugadorScheduledPort;

@ApplicationScoped
@Path("scheduled")
public class ScheduledController {

    @Inject
    JugadorScheduledPort jugadorScheduledPort;

    @GET
    @Path("calculate-edad")
    public void calculateEdad() {
        jugadorScheduledPort.calculateEdad();
    }

}
