package br.com.alura.forum.domain.resposta;

import br.com.alura.forum.domain.topico.Topico;
import br.com.alura.forum.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data // Gera getters, setters, equals, hashCode, toString
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor
@Entity
@Table(name = "respostas")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String mensagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private Boolean solucao = false;

    @ManyToOne
    @JoinColumn(name = "topico")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario autor;

}
