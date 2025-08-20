package br.com.alura.forum.domain.resposta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Integer> {
    List<Resposta> findByTopicoId(Integer topicoId);
}
