package org.ctm.arcamp.content.partidos.adapter.persistence.entity;

import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;
import org.ctm.arcamp.shared.enums.TipoPartido;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mstr_partidos")
public class PartidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "tipo_partido", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPartido tipoPartido;

    @Column(name = "fecha_partido", nullable = false)
    private Date fechaPartido;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "comentarios", columnDefinition = "TEXT")
    private String comentarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugador_principal_id", updatable = false, insertable = false)
    private JugadorEntity jugadorPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oponente_id", updatable = false, insertable = false)
    private JugadorEntity oponente;

    @Column(name = "jugador_principal_id")
    private Long jugadorPrincipalId;

    @Column(name = "oponente_id")
    private Long oponenteId;
}
