package org.ctm.arcamp.content.golpes.adapter.persistence.entity;

import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.content.puntos.adapter.persistence.entity.PuntoEntity;
import org.ctm.arcamp.content.tipo_golpe.adapter.persistence.entity.TipoGolpeEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mstr_golpes")
public class GolpeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "numero_golpe", nullable = false)
    private Long numeroGolpe;

    @Column(name = "tipo_golpe_id", nullable = false)
    private Long tipoGolpeId;

    @Column(name = "jugador_id", nullable = false)
    private Long jugadorId;

    @Column(name = "punto_id", nullable = false)
    private Long puntoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_golpe_id", updatable = false, insertable = false)
    private TipoGolpeEntity tipoGolpe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugador_id", updatable = false, insertable = false)
    private JugadorEntity jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "punto_id", updatable = false, insertable = false)
    private PuntoEntity punto;

}
