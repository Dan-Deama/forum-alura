package br.com.alura.forum.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(@NotNull Long id,
                                     @NotBlank String titulo,
                                     @NotBlank String mensagem
) {
}
