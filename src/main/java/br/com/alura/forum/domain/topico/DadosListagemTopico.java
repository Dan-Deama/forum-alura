package br.com.alura.forum.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(Integer id,
                                  String titulo,
                                  String mensagem,
                                  LocalDateTime dataCriacao
) {
    public DadosListagemTopico(Topico t) {
        this(t.getId(), t.getTitulo(), t.getMensagem(), t.getDataCriacao());
    }
}
