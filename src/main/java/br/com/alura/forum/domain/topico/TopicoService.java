package br.com.alura.forum.domain.topico;

import br.com.alura.forum.domain.usuario.Usuario;
import br.com.alura.forum.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DadosTopico criar(DadosTopico dto) {
        var topico = modelMapper.map(dto, Topico.class);

        // Se precisar associar o autor pelo ID
        if (dto.autorId() != null) {
            var autor = usuarioRepository.findById(dto.autor().id())
                    .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
            topico.setAutor(autor);
        }

        topico = topicoRepository.save(topico);
        return modelMapper.map(topico, DadosTopico.class);
    }

    public DadosTopico buscarPorId(Integer id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        return modelMapper.map(topico, DadosTopico.class);
    }

    public List<DadosTopico> listarTodos() {
        return topicoRepository.findAll().stream()
                .map(t -> modelMapper.map(t, DadosTopico.class))
                .collect(Collectors.toList());
    }

    public List<DadosTopico> listarPorAutor(Integer autorId) {
        return topicoRepository.findByAutorId(autorId).stream()
                .map(t -> modelMapper.map(t, DadosTopico.class))
                .collect(Collectors.toList());
    }

    public void deletar(Integer id) {
        topicoRepository.deleteById(id);
    }

    public void atualizar(Integer id, @Valid DadosTopico dto) {

    }
}
