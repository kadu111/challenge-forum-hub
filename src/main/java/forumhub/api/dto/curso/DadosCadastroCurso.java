package forumhub.api.dto.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(
        @NotBlank String nome,
        @NotBlank String categoria
) {}
