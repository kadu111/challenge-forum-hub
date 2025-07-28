package forumhub.api.dto.topico;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        String autor,
        String curso
) {}