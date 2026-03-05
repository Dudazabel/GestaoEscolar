package com.example.GestaoEscolar.service;

import com.example.GestaoEscolar.dto.TurmaDTO.TurmaRequisicaoDTO;
import com.example.GestaoEscolar.dto.TurmaDTO.TurmaRespostaDTO;
import com.example.GestaoEscolar.mapper.TurmaMapper;
import com.example.GestaoEscolar.model.Turma;
import com.example.GestaoEscolar.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository repository;
    private final TurmaMapper mapper;

    public TurmaService(TurmaRepository repository, TurmaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public TurmaRespostaDTO cadastrarTurma(TurmaRequisicaoDTO requisicao) throws SQLException{
        Turma turma = mapper.DTOParaEntidade(requisicao);
        return mapper.EntidadeParaDTO(repository.cadastrarTurma(turma));
    }

    public List<TurmaRespostaDTO> listarTurmas() throws SQLException{
        return mapper.EntidadeParaDTOList(repository.listarTurmas());
    }

    public TurmaRespostaDTO procurarTurmaID(int id) throws SQLException{
        return mapper.EntidadeParaDTO(repository.procurarTurmaID(id));
    }

    public void atualizarTurma(int id, TurmaRequisicaoDTO requisicao) throws SQLException{
        Turma turma = mapper.DTOParaEntidade(requisicao);
        repository.atualizarTurma(id, turma);
    }

    public void deletarTurma(int id) throws SQLException{
        repository.deletarTurma(id);
    }
}
