package br.com.alura.forum.domain.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilController {
    @Autowired
    private PerfilService perfilService;

    @PostMapping
    public ResponseEntity<DadosPerfil> criar(@RequestBody DadosPerfil dto) {
        DadosPerfil criado = perfilService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<DadosPerfil>> listar() {
        return ResponseEntity.ok(perfilService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosPerfil> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(perfilService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        perfilService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
