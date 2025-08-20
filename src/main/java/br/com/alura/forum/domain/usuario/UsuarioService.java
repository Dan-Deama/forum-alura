package br.com.alura.forum.domain.usuario;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DadosUsuario salvar(DadosUsuario dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        usuario = usuarioRepository.save(usuario);
        return modelMapper.map(usuario, DadosUsuario.class);
    }

    public DadosUsuario buscarPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return modelMapper.map(usuario, DadosUsuario.class);
    }

    public List<DadosUsuario> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(u -> modelMapper.map(u, DadosUsuario.class))
                .collect(Collectors.toList());
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
