package com.example.GestaoEscolar.repository;

import com.example.GestaoEscolar.model.Aula;
import com.example.GestaoEscolar.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AulaRepository {

    public Aula cadastrarAula(Aula aula) throws SQLException{
        String query = "INSERT INTO aula(turma_id, data_hora, assunto) VALUES (?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setInt(1, aula.idTurma);
            stmt.setObject(2, aula.DataHora);
            stmt.setString(3, aula.assunto);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                aula.setId(rs.getInt(1));
            }
        }
        return aula;
    }

    public List<Aula> listarAulas() throws SQLException{
        String query = "SELECT id, turma_id, data_hora, assunto FROM aula";

        List<Aula> aulas = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                    int id = rs.getInt("id");
                    int idTurma = rs.getInt("turma_id");
                    LocalDateTime dataHora = rs.getObject("data_hora", LocalDateTime.class);
                    String assunto = rs.getString("assunto");

                    var aula = new Aula(id, idTurma, dataHora, assunto);
                    aulas.add(aula);
                }
        }
        return aulas;
    }

    public Aula procurarAulaID(int ID) throws SQLException{
        String query = "SELECT id, turma_id, data_hora, assunto FROM aula WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, ID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                int idTurma = rs.getInt("turma_id");
                LocalDateTime dataHora = rs.getObject("data_hora", LocalDateTime.class);
                String assunto = rs.getString("assunto");

                var aula = new Aula(id, idTurma, dataHora, assunto);
                return aula;
            }
        }
        return  null;
    }

    public void atualizarAula(int id, Aula aula) throws SQLException{
        String query = "UPDATE aula SET turma_id = ?, data_hora = ?, assunto = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, aula.idTurma);
            stmt.setObject(2, aula.DataHora);
            stmt.setString(3, aula.assunto);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void deletarAula(int id) throws SQLException{
        String query = "DELETE FROM aula WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
