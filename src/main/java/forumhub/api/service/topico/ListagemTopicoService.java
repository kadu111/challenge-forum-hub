package forumhub.api.service.topico;

import forumhub.api.domain.topico.TopicoRepository;
import forumhub.api.dto.topico.DadosListagemTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListagemTopicoService {

    @Autowired
    private TopicoRepository repository;

    public org.springframework.data.domain.Page<DadosListagemTopico> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTopico::new);
    }
}