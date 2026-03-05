package com.example.GestaoEscolar.dto.TurmaDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record TurmaRequisicaoDTO(@NotNull(message = "O nome da Turma não deve ser nulo!")
                                 String nome,
                                 @NotNull(message = "O id de curso da Turma não deve ser nulo!")
                                 @PositiveOrZero(message = "O id de curso da Turma não deve ser negativo!")
                                 int idCurso,
                                 @NotNull(message = "O id de professor da Turma não deve ser nulo!")
                                 @PositiveOrZero(message = "O id de professor da Turma não deve ser negativo!")
                                 int idProfessor) {
}
