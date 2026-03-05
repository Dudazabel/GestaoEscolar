package com.example.GestaoEscolar.dto.AulaDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public record AulaRequisicaoDTO(@NotNull(message = "O id de turma da Aula não deve ser nulo!")
                                @PositiveOrZero(message = "O id de turma da Aula não deve ser negativo!")
                                int idTurma,
                                @NotNull(message = "A data e/ou a hora da Aula não devem ser nulas!")
                                LocalDateTime dataHora,
                                @NotNull(message = "O assunto da Aula não deve ser nulo!")
                                String assunto) {
}
