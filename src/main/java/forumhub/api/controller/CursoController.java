package forumhub.api.controller;

import forumhub.api.dto.curso.DadosCadastroCurso;
import forumhub.api.dto.curso.DadosDetalhamentoCurso;
import forumhub.api.infra.service.curso.CadastroCursoService;
import forumhub.api.infra.service.curso.ListagemCursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CadastroCursoService cadastroService;

    @Autowired
    private ListagemCursoService listagemService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoCurso> cadastrar(@RequestBody @Valid DadosCadastroCurso dados) {
        return ResponseEntity.ok(cadastroService.cadastrar(dados));
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoCurso>> listar() {
        return ResponseEntity.ok(listagemService.listar());
    }
}