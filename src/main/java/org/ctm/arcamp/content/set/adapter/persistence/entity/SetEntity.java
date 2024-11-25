package org.ctm.arcamp.content.set.adapter.persistence.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.content.partidos.adapter.persistence.entity.PartidoEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mstr_set")
public class SetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "numero_set", nullable = false)
    private Integer numero_set;

    @Column(name = "partido_id", nullable = false)
    private Long partido_id;

    @Column(name = "ganador_id")
    private Long ganador_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "partido_id", insertable = false, updatable = false)
    private PartidoEntity partido;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ganador_id", insertable = false, updatable = false)
    private JugadorEntity ganador;

}
