package com.example.GestaoEscolar.service;

import com.example.GestaoEscolar.dto.AlunoDTO.AlunoRequisicaoDTO;
import com.example.GestaoEscolar.dto.AlunoDTO.AlunoRespostaDTO;
import com.example.GestaoEscolar.mapper.AlunoMapper;
import com.example.GestaoEscolar.model.Aluno;
import com.example.GestaoEscolar.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;
    private final AlunoMapper mapper;
    public AlunoService (AlunoRepository repository, AlunoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public AlunoRespostaDTO cadastrarAluno(AlunoRequisicaoDTO requisicao) throws SQLException{
        Aluno aluno = mapper.DTOParaEntidade(requisicao);
        Aluno alunoSalvo = repository.cadastrarAluno(aluno);
        return mapper.EntidadeParaDTO(alunoSalvo);
    }

    public List<AlunoRespostaDTO> listaAlunos()throws SQLException{
        return mapper.EntidadeParaDTOList(repository.listarAlunos());
    }

    public AlunoRespostaDTO procurarAlunoID(int id) throws SQLException{
        return mapper.EntidadeParaDTO(repository.procurarAlunoID(id));
    }

    public void atualizarAluno(int id, AlunoRequisicaoDTO requisicao) throws SQLException{
        Aluno aluno = mapper.DTOParaEntidade(requisicao);
        repository.atualizarAluno(id, aluno);
    }

    public void deletarAluno(int id) throws SQLException{
        repository.deletarAluno(id);
    }


}
