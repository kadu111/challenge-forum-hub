package forumhub.api.controller;

import forumhub.api.domain.usuario.Usuario;
import forumhub.api.dto.usuario.DadosAutenticacao;
import forumhub.api.infra.security.DadosTokenJWT;
import forumhub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> login(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);

        var usuario = (Usuario) authentication.getPrincipal();
        var jwtToken = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new DadosTokenJWT(jwtToken));
    }
}
