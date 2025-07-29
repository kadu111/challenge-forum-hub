package forumhub.api.infra.service.usuario;

import forumhub.api.domain.usuario.Usuario;
import forumhub.api.dto.usuario.DadosCadastroUsuario;
import forumhub.api.dto.usuario.DadosDetalhamentoUsuario;
import forumhub.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public DadosDetalhamentoUsuario cadastrar(DadosCadastroUsuario dados) {
        var usuario = new Usuario(null, dados.nome(), dados.email(), dados.senha());
        repository.save(usuario);
        return new DadosDetalhamentoUsuario(usuario.getId(), usuario.getNome(), usuario.getLogin());
    }
}
