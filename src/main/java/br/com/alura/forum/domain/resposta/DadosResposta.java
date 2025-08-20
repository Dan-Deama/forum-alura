package br.com.alura.forum.domain.resposta;

import br.com.alura.forum.domain.usuario.DadosUsuario;

import java.time.LocalDateTime;

public record DadosResposta(
        Integer id,
        String mensagem,
        Integer topicoId,
        LocalDateTime dataCriacao,
        Boolean solucao,
        DadosUsuario autorId
) {
}
