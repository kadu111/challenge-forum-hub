package forumhub.api.dto.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoTopico(
        @NotBlank String titulo,
        @NotBlank String mensagem
) {}