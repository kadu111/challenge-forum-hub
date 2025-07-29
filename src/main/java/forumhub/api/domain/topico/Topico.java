package forumhub.api.domain.topico;

import forumhub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import forumhub.api.domain.curso.Curso;

import java.time.LocalDateTime;

@Entity
@Table(name = "topico", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"titulo", "mensagem"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;


    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    public Topico(Long id, String titulo, String mensagem, Usuario autor, Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }
}
