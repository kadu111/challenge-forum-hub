package forumhub.api.service.topico;

import forumhub.api.domain.topico.Topico;
import forumhub.api.dto.topico.DadosDetalhamentoTopico;
import forumhub.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetalhamentoTopicoService {

    @Autowired
    private TopicoRepository repository;

    public Optional<DadosDetalhamentoTopico> detalhar(Long id) {
        Optional<Topico> topico = repository.findById(id);
        return topico.map(t -> new DadosDetalhamentoTopico(
                t.getId(),
                t.getTitulo(),
                t.getMensagem(),
                t.getAutor().getNome(), // assumindo autor é Usuario
                t.getCurso()
        ));
    }
}
