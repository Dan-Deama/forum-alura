package br.com.alura.forum.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Integer id,
                                      String titulo,
                                      String mensagem,
                                      LocalDateTime dataCriacao,
                                      String nomeAutor

) {
    public DadosDetalhamentoTopico(Topico t) {
        this(
                t.getId(),
                t.getTitulo(),
                t.getMensagem(),
                t.getDataCriacao(),
                t.getAutor().getNome()
        );

    }
}