package forumhub.api.service.curso;

import forumhub.api.domain.curso.Curso;
import forumhub.api.domain.curso.CursoRepository;
import forumhub.api.dto.curso.DadosCadastroCurso;
import forumhub.api.dto.curso.DadosDetalhamentoCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCursoService {

    @Autowired
    private CursoRepository repository;

    @Transactional
    public DadosDetalhamentoCurso cadastrar(DadosCadastroCurso dados) {
        Curso curso = new Curso(null, dados.nome(), dados.categoria());
        repository.save(curso);
        return new DadosDetalhamentoCurso(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
