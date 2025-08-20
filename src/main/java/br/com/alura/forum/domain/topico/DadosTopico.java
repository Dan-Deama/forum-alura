package br.com.alura.forum.domain.topico;

import br.com.alura.forum.domain.resposta.DadosResposta;
import br.com.alura.forum.domain.usuario.DadosUsuario;

import java.time.LocalDateTime;
import java.util.List;

public record DadosTopico(
        Integer id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        DadosUsuario autor,
        DadosUsuario autorId,
        List<DadosResposta> respostas
) {
}
