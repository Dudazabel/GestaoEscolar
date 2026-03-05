package com.example.GestaoEscolar.mapper;

import com.example.GestaoEscolar.dto.NotaDTO.NotaRequisicaoDTO;
import com.example.GestaoEscolar.dto.NotaDTO.NotaRespostaDTO;
import com.example.GestaoEscolar.model.Nota;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaMapper {

    public Nota DTOParaEntidade(NotaRequisicaoDTO requisicao){
        return new Nota(requisicao.idAluno(), requisicao.idAula(), requisicao.valor());
    }

    public NotaRespostaDTO EntidadeParaDTO(Nota nota){
        return new NotaRespostaDTO(nota.getId(), nota.getIdAluno(), nota.getIdAula(), nota.getValor());
    }

    public List<NotaRespostaDTO> EntidadeParaDTOList(List<Nota> notas){
        return notas.stream()
                    .map(this::EntidadeParaDTO)
                    .toList();
    }
}
