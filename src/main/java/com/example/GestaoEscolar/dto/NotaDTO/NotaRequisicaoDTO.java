package com.example.GestaoEscolar.dto.NotaDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record NotaRequisicaoDTO(@NotNull(message = "O id de aluno da Nota não deve ser nulo!")
                                @PositiveOrZero(message = "O id de aluno da Nota não deve ser negativo!")
                                int idAluno,
                                @NotNull(message = "O id de aula da Nota não deve ser nulo!")
                                @PositiveOrZero(message = "O id de aula da Nota não deve ser negativo!")
                                int idAula,
                                @NotNull(message = "O valor da Nota não deve ser nulo!")
                                @PositiveOrZero(message = "O valor da Nota não deve ser negativo!")
                                double valor) {
}
