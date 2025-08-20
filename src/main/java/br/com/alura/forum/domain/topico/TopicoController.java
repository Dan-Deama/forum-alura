package br.com.alura.forum.domain.topico;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@Validated
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DadosTopico> criar(
            @RequestBody @Valid DadosTopico dto,
            UriComponentsBuilder uriBuilder
    ) {
        DadosTopico criado = topicoService.criar(dto);
        URI uri = uriBuilder
                .path("/topicos/{id}")
                .buildAndExpand(criado.id())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(criado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosTopico> buscarPorId(@PathVariable Integer id) {
        DadosTopico dto = topicoService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosTopico>> listarTodos() {
        List<DadosTopico> lista = topicoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(params = "autorId")
    public ResponseEntity<List<DadosTopico>> listarPorAutor(
            @RequestParam Integer autorId
    ) {
        List<DadosTopico> lista = topicoService.listarPorAutor(autorId);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(
            @PathVariable Integer id,
            @RequestBody @Valid DadosTopico dto
    ) {
        topicoService.atualizar(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        topicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
