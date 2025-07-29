package forumhub.api.service.curso;

import forumhub.api.domain.curso.CursoRepository;
import forumhub.api.dto.curso.DadosDetalhamentoCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListagemCursoService {

    @Autowired
    private CursoRepository repository;

    public List<DadosDetalhamentoCurso> listar() {
        return repository.findAll()
                .stream()
                .map(c -> new DadosDetalhamentoCurso(c.getId(), c.getNome(), c.getCategoria()))
                .collect(Collectors.toList());
    }
}
