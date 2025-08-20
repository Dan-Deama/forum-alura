package br.com.alura.forum.domain.resposta;

import br.com.alura.forum.domain.topico.Topico;
import br.com.alura.forum.domain.topico.TopicoRepository;
import br.com.alura.forum.domain.usuario.Usuario;
import br.com.alura.forum.domain.usuario.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DadosResposta criar(DadosResposta dto) {
        Resposta resposta = modelMapper.map(dto, Resposta.class);

        if (dto.topicoId() != null) {
            Topico topico = topicoRepository.findById(dto.topicoId())
                    .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
            resposta.setTopico(topico);
        }

        if (dto.autorId() != null) {
            Usuario autor = usuarioRepository.findById(dto.autorId().id())
                    .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
            resposta.setAutor(autor);
        }

        resposta = respostaRepository.save(resposta);
        return modelMapper.map(resposta, DadosResposta.class);
    }

    public List<DadosResposta> listarPorTopico(Integer topicoId) {
        return respostaRepository.findByTopicoId(topicoId).stream()
                .map(r -> modelMapper.map(r, DadosResposta.class))
                .collect(Collectors.toList());
    }

    public void deletar(Integer id) {
        respostaRepository.deleteById(id);
    }

}
