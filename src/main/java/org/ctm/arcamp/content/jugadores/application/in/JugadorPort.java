package org.ctm.arcamp.content.jugadores.application.in;

import org.ctm.arcamp.content.jugadores.domain.Jugador;
import org.ctm.arcamp.content.jugadores.domain.in.JugadorInDomain;
import org.ctm.arcamp.content.jugadores.domain.out.JugadorOutDomain;
import org.ctm.arcamp.shared.search.domain.Filter;
import org.ctm.arcamp.shared.search.domain.Search;
import org.hibernate.query.SortDirection;

import java.util.List;

public interface JugadorPort {
    Jugador get(Long id);

    Jugador create(JugadorInDomain inDomain);

    Jugador update(JugadorInDomain inDomain);

    void delete(Long id);

    List<JugadorOutDomain> search(Search search);
}
