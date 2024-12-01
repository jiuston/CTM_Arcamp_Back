package org.ctm.arcamp.content.jugadores.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.content.jugadores.application.in.JugadorPort;
import org.ctm.arcamp.content.jugadores.application.mapper.JugadorDomainMapper;
import org.ctm.arcamp.content.jugadores.application.out.JugadorRepositoryPort;
import org.ctm.arcamp.content.jugadores.domain.Jugador;
import org.ctm.arcamp.content.jugadores.domain.in.JugadorInDomain;
import org.ctm.arcamp.content.jugadores.domain.out.JugadorOutDomain;
import org.ctm.arcamp.shared.search.adapter.repository.SearchRepository;
import org.ctm.arcamp.shared.search.application.out.SearchRepositoryPort;
import org.ctm.arcamp.shared.search.domain.Filter;
import org.ctm.arcamp.shared.search.domain.Search;
import org.hibernate.query.SortDirection;

import java.util.List;

@ApplicationScoped
public class JugadorService implements JugadorPort {

    @Inject
    JugadorRepositoryPort jugadorRepositoryPort;

    @Inject
    SearchRepositoryPort searchRepositoryPort;

    @Inject
    JugadorDomainMapper mapper;

    @Override
    public Jugador get(Long id) {
        return mapper.toOutDomain(jugadorRepositoryPort.get(id));
    }

    @Override
    @Transactional
    public Jugador create(JugadorInDomain inDomain) {
        return mapper.toDomain(jugadorRepositoryPort.create(mapper.toEntity(inDomain)));
    }

    @Override
    @Transactional
    public Jugador update(JugadorInDomain inDomain) {
        JugadorEntity existingJugador = jugadorRepositoryPort.get(inDomain.getId());
        mapper.update(inDomain, existingJugador);
        return mapper.toOutDomain(jugadorRepositoryPort.update(existingJugador));
    }

    @Override
    public void delete(Long id) {
        jugadorRepositoryPort.delete(id);
    }

    @Override
    public List<JugadorOutDomain> search(Search search) {
        List<JugadorEntity> jugadores = searchRepositoryPort.search(search, JugadorEntity.class);
        return jugadores.stream().map(mapper::toOutDomain).toList();
    }
}
