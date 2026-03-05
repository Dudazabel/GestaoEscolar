package com.example.GestaoEscolar.dto.ProfessorDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ProfessorRequisicaoDTO(@NotNull(message = "O nome do Professor não deve ser nulo!")
                                     String nome,
                                     @NotNull(message = "O email do Professor não deve ser nulo!")
                                     @Email(message = "Adicione um email válido!")
                                     String email,
                                     @NotNull(message = "A disciplina do Professor não deve ser nula!")
                                     String disciplina) {
}
