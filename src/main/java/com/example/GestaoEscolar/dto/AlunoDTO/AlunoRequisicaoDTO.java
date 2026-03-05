package com.example.GestaoEscolar.dto.AlunoDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record AlunoRequisicaoDTO(@NotNull(message = "O nome do Aluno não deve ser nulo!")
                                 String nome,
                                 @NotNull(message = "O email do Aluno não deve ser nulo!")
                                 @Email(message = "Adicione um email válido!")
                                 String email,
                                 @NotNull(message = "A matrícula do Aluno não deve ser nula!")
                                 String matricula,
                                 @NotNull(message = "A data de nascimento do Aluno não deve ser nula!")
                                 LocalDate dataNascimento) {
}
