package com.example.GestaoEscolar.model;

public class Nota {

    public int id;
    public int idAluno;
    public int idAula;
    public double valor;

    public Nota(int id, int idAluno, int idAula, double valor) {
        this.id = id;
        this.idAluno = idAluno;
        this.idAula = idAula;
        this.valor = valor;
    }

    public Nota(int idAluno, int idAula, double valor) {
        this.idAluno = idAluno;
        this.idAula = idAula;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
