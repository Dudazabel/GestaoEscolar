package com.example.GestaoEscolar.dto.AulaDTO;

import java.time.LocalDateTime;

public record AulaRespostaDTO(int id,
                              int idTurma,
                              LocalDateTime dataHora,
                              String assunto) {
}
