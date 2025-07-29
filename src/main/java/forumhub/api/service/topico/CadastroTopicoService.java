package forumhub.api.service.topico;

import forumhub.api.domain.curso.CursoRepository;
import forumhub.api.domain.topico.Topico;
import forumhub.api.domain.topico.TopicoRepository;
import forumhub.api.domain.usuario.Usuario;
import forumhub.api.domain.usuario.UsuarioRepository;
import forumhub.api.dto.topico.DadosCadastroTopico;
import forumhub.api.dto.topico.DadosDetalhamentoTopico;
import forumhub.api.domain.curso.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroTopicoService {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public DadosDetalhamentoTopico cadastrar(DadosCadastroTopico dados) {
        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            throw new IllegalArgumentException("Tópico já existente com mesmo título e mensagem.");
        }

        Usuario autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Curso curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        Topico topico = new Topico(null, dados.titulo(), dados.mensagem(), autor, curso);

        repository.save(topico);

        return new DadosDetalhamentoTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome()
        );
    }
}
