package br.com.alura.forum.domain.usuario;

import br.com.alura.forum.domain.perfil.DadosPerfil;

import java.util.List;

public record DadosUsuario(
        Integer id,
        String nome,
        String email,
        List<DadosPerfil> perfis

) {
}
