package com.example.GestaoEscolar.service;

import com.example.GestaoEscolar.dto.ProfessorDTO.ProfessorRequisicaoDTO;
import com.example.GestaoEscolar.dto.ProfessorDTO.ProfessorRespostaDTO;
import com.example.GestaoEscolar.mapper.ProfessorMapper;
import com.example.GestaoEscolar.model.Professor;
import com.example.GestaoEscolar.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public ProfessorService(ProfessorRepository repository, ProfessorMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProfessorRespostaDTO cadastrarProfessor(ProfessorRequisicaoDTO requisicao) throws SQLException {
        Professor professor = mapper.DTOParaEntidade(requisicao);
        Professor professorSalvo = repository.cadastrarProfessor(professor);
        return mapper.EntidadeParaDTO(professorSalvo);
    }

    public List<ProfessorRespostaDTO> listarProfessores() throws SQLException{
        return mapper.EntidadeParaDTOLista(repository.listarProfessores());
    }

    public ProfessorRespostaDTO procurarProfessorID(int id) throws SQLException{
        return mapper.EntidadeParaDTO(repository.buscarProfessorID(id));
    }

    public void atualizarProfessor(int id, ProfessorRequisicaoDTO requisicao) throws SQLException{
        Professor professor = mapper.DTOParaEntidade(requisicao);
        repository.atualizarProfessor(id, professor);
    }

    public void deletarProfessor(int id) throws SQLException{
        repository.deletarProfessor(id);
    }
}
