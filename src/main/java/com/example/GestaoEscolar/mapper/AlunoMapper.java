package com.example.GestaoEscolar.mapper;

import com.example.GestaoEscolar.dto.AlunoDTO.AlunoRequisicaoDTO;
import com.example.GestaoEscolar.dto.AlunoDTO.AlunoRespostaDTO;
import com.example.GestaoEscolar.model.Aluno;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoMapper {

    public Aluno DTOParaEntidade(AlunoRequisicaoDTO requisicao){
        return new Aluno(requisicao.nome(), requisicao.email(), requisicao.matricula(), requisicao.dataNascimento());
    }

    public AlunoRespostaDTO EntidadeParaDTO(Aluno aluno){
        return new AlunoRespostaDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getMatricula(), aluno.getDataNascimento());
    }

    public List<AlunoRespostaDTO> EntidadeParaDTOList(List<Aluno> alunos){
        return alunos.stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
