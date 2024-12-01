package org.ctm.arcamp.content.jugadores.adapter.persistence.entity;

import jakarta.persistence.*;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.content.club.adapter.persistence.entity.ClubEntity;
import org.ctm.arcamp.content.partidos.adapter.persistence.entity.PartidoEntity;
import org.ctm.arcamp.content.usuarios.adapter.persistence.entity.UsuarioEntity;
import org.ctm.arcamp.shared.enums.EstiloJuego;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mstr_jugadores")
public class JugadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "diestro", nullable = false)
    private Boolean diestro;

    @Column(name = "porcentaje_victorias", nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double porcentajeVictorias;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "edad", nullable = false) //TODO calculado en la bbdd
    private Integer edad;

    @Column(name = "nacionalidad", nullable = false)
    private String nacionalidad;

    @Column(name = "estilo_juego", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstiloJuego estiloJuego;

    @Column(name = "comentarios", columnDefinition = "TEXT")
    private String comentarios;

    @Column(name = "club_id")
    private Long clubId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "club_id", insertable = false, updatable = false)
    private ClubEntity club;

    @OneToOne(mappedBy = "jugador")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "jugadorPrincipal", fetch = FetchType.LAZY)
    private Set<PartidoEntity> partidosComoPrincipal;

    @OneToMany(mappedBy = "oponente", fetch = FetchType.LAZY)
    private Set<PartidoEntity> partidosComoOponente;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (fechaNacimiento != null) {
            this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        }
        if (porcentajeVictorias == null) {
            this.porcentajeVictorias = 0.0;
        }
    }
}
