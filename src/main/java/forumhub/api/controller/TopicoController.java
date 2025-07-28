package forumhub.api.controller;

import forumhub.api.dto.topico.DadosCadastroTopico;
import forumhub.api.dto.topico.DadosDetalhamentoTopico;
import forumhub.api.service.topico.CadastroTopicoService;
import forumhub.api.service.topico.DetalhamentoTopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private CadastroTopicoService cadastroService;

    @Autowired
    private DetalhamentoTopicoService detalhamentoService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        var dto = cadastroService.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {
        return detalhamentoService.detalhar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
