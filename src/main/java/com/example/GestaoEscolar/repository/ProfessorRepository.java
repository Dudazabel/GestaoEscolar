package com.example.GestaoEscolar.repository;

import com.example.GestaoEscolar.model.Professor;
import com.example.GestaoEscolar.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepository {

    public Professor cadastrarProfessor(Professor professor) throws SQLException{
        String query = "INSERT INTO professor(nome, email, disciplina) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                professor.setId(rs.getInt(1));
                return professor;
            }
        }

        return null;
    }

    public List<Professor> listarProfessores() throws SQLException{
        String query = "SELECT id, nome, email, disciplina FROM professor";

        List<Professor> professores = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String matricula = rs.getString("matricula");

                var professor = new Professor(id, nome, email, matricula);
                professores.add(professor);
            }

        }

        return professores;
    }

    public Professor buscarProfessorID(int ID) throws SQLException{
        String query = "SELECT id, nome, email, disciplina FROM professor WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String matricula = rs.getString("matricula");

                var professor = new Professor(id, nome, email, matricula);
                return professor;
            }
        }

        return null;
    }

    public void atualizarProfessor(int id, Professor professor) throws SQLException{
        String query = "UPDATE professor SET nome = ?, email = ?, disciplina = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void deletarProfessor(int id) throws SQLException{
        String query = "DELETE FROM professor WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
        }
    }
 }
