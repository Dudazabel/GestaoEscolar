package com.example.GestaoEscolar.mapper;

import com.example.GestaoEscolar.dto.TurmaDTO.TurmaRequisicaoDTO;
import com.example.GestaoEscolar.dto.TurmaDTO.TurmaRespostaDTO;
import com.example.GestaoEscolar.model.Turma;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurmaMapper {

    public Turma DTOParaEntidade(TurmaRequisicaoDTO requisicao){
        return new Turma(requisicao.nome(), requisicao.idCurso(), requisicao.idProfessor());
    }

    public TurmaRespostaDTO EntidadeParaDTO(Turma turma){
        return new TurmaRespostaDTO(turma.getId(), turma.getNome(), turma.getIdCurso(), turma.getIdProfessor());
    }

    public List<TurmaRespostaDTO> EntidadeParaDTOList(List<Turma> turmas){
        return turmas.stream()
                     .map(this::EntidadeParaDTO)
                     .toList();
    }
}
