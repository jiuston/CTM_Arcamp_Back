package org.ctm.arcamp.content.scheduled.service;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.ctm.arcamp.content.scheduled.port.JugadorScheduledPort;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@ApplicationScoped
public class JugadorScheduledService implements JugadorScheduledPort {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    @Scheduled(cron = "0 0 1 * * ?")
    public void calculateEdad() {
        entityManager.createQuery(
                        "UPDATE JugadorEntity j SET j.edad = " +
                                "FUNCTION('date_part', 'year', FUNCTION('age', j.fechaNacimiento))")
                .executeUpdate();
    }
}
