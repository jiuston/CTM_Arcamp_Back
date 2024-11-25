package org.ctm.arcamp.content.puntos.adapter.persistence.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.content.saques.adapter.persistence.entity.SaqueEntity;
import org.ctm.arcamp.content.set.adapter.persistence.entity.SetEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mstr_puntos")
public class PuntoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "numero_punto", nullable = false)
    private Integer numeroPunto;

    @Column(name = "ganador_id")
    private Long ganadorId;

    @Column(name = "saque_id", updatable = false, insertable = false)
    private Long saqueId;

    @Column(name = "set_id")
    private Long setId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ganador_id", insertable = false, updatable = false)
    private JugadorEntity ganador;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "saque_id")
    private SaqueEntity saque;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "set_id", updatable = false, insertable = false)
    private SetEntity set;

}
