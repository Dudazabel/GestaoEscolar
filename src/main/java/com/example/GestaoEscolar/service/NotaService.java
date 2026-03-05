package com.example.GestaoEscolar.service;

import com.example.GestaoEscolar.dto.NotaDTO.NotaRequisicaoDTO;
import com.example.GestaoEscolar.dto.NotaDTO.NotaRespostaDTO;
import com.example.GestaoEscolar.mapper.NotaMapper;
import com.example.GestaoEscolar.model.Nota;
import com.example.GestaoEscolar.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class NotaService {

    private final NotaRepository repository;
    private final NotaMapper mapper;

    public NotaService(NotaRepository repository, NotaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public NotaRespostaDTO cadastrarNota(NotaRequisicaoDTO requiscao) throws SQLException{
        Nota nota = mapper.DTOParaEntidade(requiscao);
        return mapper.EntidadeParaDTO(repository.cadastrarNota(nota));
    }

    public List<NotaRespostaDTO> listarNotas() throws SQLException{
        return mapper.EntidadeParaDTOList(repository.listarNotas());
    }

    public NotaRespostaDTO procurarNotaID(int id) throws SQLException{
        return mapper.EntidadeParaDTO(repository.procurarNotaID(id));
    }

    public void atualizarNota(int id, NotaRequisicaoDTO requisicao) throws SQLException{
        Nota nota = mapper.DTOParaEntidade(requisicao);
        repository.atualizarNota(id, nota);
    }

    public void deletarNota(int id) throws SQLException{
        repository.deletarNota(id);
    }
}
