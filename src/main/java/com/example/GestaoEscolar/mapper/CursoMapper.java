package com.example.GestaoEscolar.mapper;

import com.example.GestaoEscolar.dto.CursoDTO.CursoRequisicaoDTO;
import com.example.GestaoEscolar.dto.CursoDTO.CursoRespostaDTO;
import com.example.GestaoEscolar.model.Curso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CursoMapper {

    public Curso DTOParaEntidade(CursoRequisicaoDTO requisicao){
        return new Curso(requisicao.nome(), requisicao.codigo());
    }

    public CursoRespostaDTO EntidadeParaDTO(Curso curso){
        return new CursoRespostaDTO(curso.getId(), curso.getNome(), curso.getCodigo());
    }

    public List<CursoRespostaDTO> EntidadeParaDTOList(List<Curso> cursos){
        return cursos.stream()
                     .map(this::EntidadeParaDTO)
                     .toList();
    }
}
