package forumhub.api.service.topico;

import forumhub.api.domain.topico.Topico;
import forumhub.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExclusaoTopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public boolean excluir(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            topicoRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
