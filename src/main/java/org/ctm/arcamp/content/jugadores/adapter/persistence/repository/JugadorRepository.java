package org.ctm.arcamp.content.jugadores.adapter.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.ctm.arcamp.content.club.application.out.ClubRepositoryPort;
import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.content.jugadores.application.out.JugadorRepositoryPort;

import java.util.Date;

@ApplicationScoped
public class JugadorRepository implements JugadorRepositoryPort {

    @Inject
    EntityManager entityManager;

    @Override
    public JugadorEntity get(Long id) {
        return entityManager.find(JugadorEntity.class, id);
    }

    @Override
    public JugadorEntity create(JugadorEntity entity) {
        preOperations(entity);
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        return entity;
    }

    @Override
    public JugadorEntity update(JugadorEntity entity) {
        preOperations(entity);
        entityManager.merge(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        JugadorEntity entity = entityManager.find(JugadorEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    private void preOperations(JugadorEntity entity) {
    }

}
