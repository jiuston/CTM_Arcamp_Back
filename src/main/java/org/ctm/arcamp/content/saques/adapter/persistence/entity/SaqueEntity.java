package org.ctm.arcamp.content.saques.adapter.persistence.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.content.tipo_saque.adapter.persistence.entity.TipoSaqueEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mstr_saques")
public class SaqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "es_falta", nullable = false)
    private Boolean esFalta;

    @Column(name = "tipo_saque_id")
    private Long tipoSaqueId;

    @Column(name = "jugador_id")
    private Long jugadorId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_saque_id", insertable = false, updatable = false)
    private TipoSaqueEntity tipoSaque;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "jugador_id", insertable = false, updatable = false)
    private JugadorEntity jugador;
}
