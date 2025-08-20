package br.com.alura.forum.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Integer> {
    List<Topico> findByAutorId(Integer autorId);
}
