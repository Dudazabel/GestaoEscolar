package com.example.GestaoEscolar.mapper;

import com.example.GestaoEscolar.dto.ProfessorDTO.ProfessorRequisicaoDTO;
import com.example.GestaoEscolar.dto.ProfessorDTO.ProfessorRespostaDTO;
import com.example.GestaoEscolar.model.Professor;

import java.util.List;

public class ProfessorMapper {

    public Professor DTOParaEntidade(ProfessorRequisicaoDTO requisicao){
        return new Professor(requisicao.nome(), requisicao.email(), requisicao.disciplina());
    }

    public ProfessorRespostaDTO EntidadeParaDTO(Professor professor){
        return new ProfessorRespostaDTO(professor.getId(), professor.getNome(), professor.getEmail(), professor.getDisciplina());
    }

    public List<ProfessorRespostaDTO> EntidadeParaDTOLista(List<Professor> professores){
        return professores.stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
