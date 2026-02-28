package com.example.GestaoEscolar.model;

import java.time.LocalDateTime;

public class Aula {

    public int id;
    public int idTurma;
    public LocalDateTime DataHora;
    public String assunto;

    public Aula(int id, int idTurma, LocalDateTime dataHora, String assunto) {
        this.id = id;
        this.idTurma = idTurma;
        DataHora = dataHora;
        this.assunto = assunto;
    }

    public Aula(int idTurma, LocalDateTime dataHora, String assunto) {
        this.idTurma = idTurma;
        DataHora = dataHora;
        this.assunto = assunto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public LocalDateTime getDataHora() {
        return DataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        DataHora = dataHora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
