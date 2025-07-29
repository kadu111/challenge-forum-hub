package forumhub.api.controller;

import forumhub.api.domain.topico.TopicoRepository;
import forumhub.api.dto.topico.DadosAtualizacaoTopico;
import forumhub.api.dto.topico.DadosCadastroTopico;
import forumhub.api.dto.topico.DadosDetalhamentoTopico;
import forumhub.api.infra.service.topico.AtualizacaoTopicoService;
import forumhub.api.infra.service.topico.CadastroTopicoService;
import forumhub.api.infra.service.topico.DetalhamentoTopicoService;
import forumhub.api.infra.service.topico.ExclusaoTopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private CadastroTopicoService cadastroService;

    @Autowired
    private DetalhamentoTopicoService detalhamentoService;

    @Autowired
    private ExclusaoTopicoService exclusaoService;

    @Autowired
    private AtualizacaoTopicoService atualizacaoService;

    @Autowired
    private TopicoRepository topicoRepository;

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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        Optional<DadosDetalhamentoTopico> dto = atualizacaoService.atualizar(id, dados);

        if (dto.isEmpty()) {
            return ResponseEntity.badRequest().body("Não foi possível atualizar o tópico. Ele pode não existir ou já existir com o mesmo título e mensagem.");
        }

        return ResponseEntity.ok(dto.get());
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        boolean excluido = exclusaoService.excluir(id);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
