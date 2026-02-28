package com.example.GestaoEscolar.service;

import com.example.GestaoEscolar.dto.AlunoDTO.AlunoRequisicaoDTO;
import com.example.GestaoEscolar.dto.AlunoDTO.AlunoRespostaDTO;
import com.example.GestaoEscolar.mapper.AlunoMapper;
import com.example.GestaoEscolar.model.Aluno;
import com.example.GestaoEscolar.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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


}
