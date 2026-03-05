package com.example.GestaoEscolar.repository;

import com.example.GestaoEscolar.model.Nota;
import com.example.GestaoEscolar.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NotaRepository {

    public Nota cadastrarNota(Nota nota)throws SQLException{
        String query = "INSERT INTO nota(aluno_id, aula_id, valor) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setInt(1, nota.idAluno);
            stmt.setInt(2, nota.idAula);
            stmt.setDouble(3, nota.valor);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                nota.setId(rs.getInt(1));
            }
        }
        return nota;
    }

    public List<Nota> listarNotas() throws SQLException{
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota";

        List<Nota> notas = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                int idAluno = rs.getInt("aluno_id");
                int idAula = rs.getInt("aula_id");
                double valor = rs.getDouble("valor");

                var nota = new Nota(id, idAluno, idAula, valor);
                notas.add(nota);
            }
        }
        return notas;
    }

    public Nota procurarNotaID(int ID) throws SQLException{
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                int idAluno = rs.getInt("aluno_id");
                int idAula = rs.getInt("aula_id");
                double valor = rs.getDouble("valor");

                var nota = new Nota(id, idAluno, idAula, valor);
                return nota;
            }
        }
        return null;
    }

    public void atualizarNota(int id, Nota nota) throws SQLException{
        String query = "UPDATE nota SET aluno_id = ?, aula_id = ?, valor = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void deletarNota(int id) throws SQLException{
        String query = "DELETE FROM nota WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
