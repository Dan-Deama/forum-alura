package br.com.alura.forum.domain.topico;

import br.com.alura.forum.domain.resposta.Resposta;
import br.com.alura.forum.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data // Gera getters, setters, equals, hashCode, toString
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor
@Entity
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String mensagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private String status;


    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario autor;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Resposta> respostas = new ArrayList<>();

}
