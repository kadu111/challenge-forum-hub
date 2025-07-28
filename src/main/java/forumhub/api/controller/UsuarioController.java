package forumhub.api.controller;

import forumhub.api.dto.usuario.DadosCadastroUsuario;
import forumhub.api.dto.usuario.DadosDetalhamentoUsuario;
import forumhub.api.service.usuario.CadastroUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastroUsuarioService service;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
        var dto = service.cadastrar(dados);
        return ResponseEntity.ok(dto);
    }
}
