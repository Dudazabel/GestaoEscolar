package com.example.GestaoEscolar.dto.CursoDTO;

import jakarta.validation.constraints.NotNull;

public record CursoRequisicaoDTO(@NotNull(message = "O nome do Curso não deve ser nulo!")
                                 String nome,
                                 @NotNull(message = "O código do Curso não deve ser nulo!")
                                 String codigo) {
}
