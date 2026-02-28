package com.example.GestaoEscolar.model;

public class Turma {

    public int id;
    public String nome;
    public int idCurso;
    public int idProfessor;

    public Turma(int id, String nome, int idCurso, int idProfessor) {
        this.id = id;
        this.nome = nome;
        this.idCurso = idCurso;
        this.idProfessor = idProfessor;
    }

    public Turma(String nome, int idCurso, int idProfessor) {
        this.nome = nome;
        this.idCurso = idCurso;
        this.idProfessor = idProfessor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
