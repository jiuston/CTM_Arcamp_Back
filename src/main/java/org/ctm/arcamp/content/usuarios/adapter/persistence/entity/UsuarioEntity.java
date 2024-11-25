package org.ctm.arcamp.content.usuarios.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ctm.arcamp.content.jugadores.adapter.persistence.entity.JugadorEntity;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mstr_usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @Column(name = "jugador_id")
    private Long jugadorId;

    @Column(name = "ultimo_login", nullable = false)
    private Date ultimo_login;

    @Column(name = "avatar_url", length = 1500)
    private String avatar_url;

    @Column(name = "creado_en", nullable = false)
    private Date creado_en;

    @Column(name = "creado_por", nullable = false)
    private String creado_por;

    @Column(name = "modificado_en")
    private Date modificado_en;

    @Column(name = "modificado_por")
    private String modificado_por;

    @OneToOne
    @JoinColumn(name = "jugador_id", updatable = false, insertable = false)
    private JugadorEntity jugador;

}
