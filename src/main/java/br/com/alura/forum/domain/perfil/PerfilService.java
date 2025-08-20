package br.com.alura.forum.domain.perfil;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DadosPerfil criar(DadosPerfil dto) {
        Perfil perfil = modelMapper.map(dto, Perfil.class);
        perfil = perfilRepository.save(perfil);
        return modelMapper.map(perfil, DadosPerfil.class);
    }

    public List<DadosPerfil> listarTodos() {
        return perfilRepository.findAll().stream()
                .map(p -> modelMapper.map(p, DadosPerfil.class))
                .collect(Collectors.toList());
    }

    public DadosPerfil buscarPorId(Integer id) {
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
        return modelMapper.map(perfil, DadosPerfil.class);
    }

    public void deletar(Integer id) {
        perfilRepository.deleteById(id);
    }

}
