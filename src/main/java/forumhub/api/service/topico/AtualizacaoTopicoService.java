package forumhub.api.service.topico;

import forumhub.api.domain.topico.Topico;
import forumhub.api.dto.topico.DadosAtualizacaoTopico;
import forumhub.api.dto.topico.DadosDetalhamentoTopico;
import forumhub.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizacaoTopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Optional<DadosDetalhamentoTopico> atualizar(Long id, DadosAtualizacaoTopico dados) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isEmpty()) {
            return Optional.empty();
        }

        Topico topico = optionalTopico.get();

        // Validação: evitar duplicatas
        if (topicoRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            return Optional.empty();
        }

        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());

        return Optional.of(new DadosDetalhamentoTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome()
        ));
    }
}
