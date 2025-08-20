package br.com.alura.forum.domain.resposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostaController {
    @Autowired
    private RespostaService respostaService;

    @PostMapping
    public ResponseEntity<DadosResposta> criar(@RequestBody DadosResposta dto) {
        DadosResposta criada = respostaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @GetMapping("/topico/{topicoId}")
    public ResponseEntity<List<DadosResposta>> listarPorTopico(@PathVariable Integer topicoId) {
        return ResponseEntity.ok(respostaService.listarPorTopico(topicoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        respostaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
