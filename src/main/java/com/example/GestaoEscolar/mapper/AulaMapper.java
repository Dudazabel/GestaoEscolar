package com.example.GestaoEscolar.mapper;

import com.example.GestaoEscolar.dto.AulaDTO.AulaRequisicaoDTO;
import com.example.GestaoEscolar.dto.AulaDTO.AulaRespostaDTO;
import com.example.GestaoEscolar.model.Aula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AulaMapper {

    public Aula DTOParaEntidade(AulaRequisicaoDTO requisicao){
        return new Aula(requisicao.idTurma(), requisicao.dataHora(), requisicao.assunto());
    }

    public AulaRespostaDTO EntidadeParaDTO(Aula aula){
        return new AulaRespostaDTO(aula.getId(), aula.idTurma, aula.getDataHora(), aula.getAssunto());
    }

    public List<AulaRespostaDTO> EntidadeParaDTOList(List<Aula> aulas){
        return aulas.stream()
                    .map(this::EntidadeParaDTO)
                    .toList();
    }
}
