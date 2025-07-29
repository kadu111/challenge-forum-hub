package forumhub.api.dto.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotBlank Long autorId,
        @NotBlank Long cursoId
) {}