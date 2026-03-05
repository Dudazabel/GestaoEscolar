package com.example.GestaoEscolar.repository;

import com.example.GestaoEscolar.model.Turma;
import com.example.GestaoEscolar.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {

    public Turma cadastrarTurma(Turma turma) throws SQLException{
        String query = "INSERT INTO turma(nome, curso_id, professor_id) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, turma.nome);
            stmt.setInt(2, turma.idCurso);
            stmt.setInt(3, turma.idProfessor);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                turma.setId(rs.getInt(1));
            }
        }

        return turma;
    }

    public List<Turma> listarTurmas() throws SQLException{
        String query = "SELECT id, nome, curso_id, professor_id FROM turma";

        List<Turma> turmas = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idCurso = rs.getInt("curso_id");
                int idProfessor = rs.getInt("professor_id");

                var turma = new Turma(id, nome, idCurso, idProfessor);
                turmas.add(turma);
            }
        }
        return turmas;
    }

    public Turma procurarTurmaID(int ID) throws SQLException{
        String query = "SELECT id, nome, curso_id, professor_id FROM turma WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idCurso = rs.getInt("curso_id");
                int idProfessor = rs.getInt("professor_id");

                var turma = new Turma(id, nome, idCurso, idProfessor);
                return turma;
            }
        }
        return null;
    }

    public void atualizarTurma(int id, Turma turma) throws SQLException{
        String query = "UPDATE turma SET nome = ?, curso_id = ?, professor_id = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, turma.nome);
            stmt.setInt(2, turma.idCurso);
            stmt.setInt(3, turma.idProfessor);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void deletarTurma(int id) throws SQLException{
        String query = "DELETE FROM turma WHERE id = ?";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
