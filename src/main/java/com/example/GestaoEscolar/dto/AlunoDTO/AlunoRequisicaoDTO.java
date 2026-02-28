package com.example.GestaoEscolar.dto.AlunoDTO;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record AlunoRequisicaoDTO(String nome,
                                 String email,
                                 String matricula,
                                 LocalDate dataNascimento) {
}
