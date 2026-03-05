package com.example.GestaoEscolar.repository;

import com.example.GestaoEscolar.model.Curso;
import com.example.GestaoEscolar.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {

    public Curso cadastrarCurso(Curso curso) throws SQLException{
        String query = "INSERT INTO curso(nome, codigo) VALUES (?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, curso.nome);
            stmt.setString(2, curso.codigo);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                curso.setId(rs.getInt(1));
            }
        }
        return curso;
    }

    public List<Curso> listarCursos() throws SQLException{
        String query = "SELECT id, nome, codigo FROM curso";

        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");

                Curso curso = new Curso(id, nome, codigo);
                cursos.add(curso);
            }
        }
        return cursos;
    }

    public Curso procurarCursoID(int ID) throws SQLException{
        String query = "SELECT id, nome, codigo FROM curso WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");

                var curso = new Curso(id, nome, codigo);
                return curso;
            }
        }
        return null;
    }

    public void atualizarCurso(int id, Curso curso) throws SQLException{
        String query = "UPDATE curso SET nome = ?, codigo = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, curso.nome);
            stmt.setString(2, curso.codigo);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void deletarCurso(int id) throws SQLException{
        String query = "DELETE FROM curso WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
