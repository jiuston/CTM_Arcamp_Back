package org.ctm.arcamp.content.jugadores.application.out;

import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.content.jugadores.domain.Jugador;

public interface JugadorRepositoryPort {
    JugadorEntity get(Long id);

    JugadorEntity create(JugadorEntity entity);

    JugadorEntity update(JugadorEntity entity);

    void delete(Long id);
}
