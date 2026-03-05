package com.example.GestaoEscolar.service;

import com.example.GestaoEscolar.dto.AulaDTO.AulaRequisicaoDTO;
import com.example.GestaoEscolar.dto.AulaDTO.AulaRespostaDTO;
import com.example.GestaoEscolar.mapper.AulaMapper;
import com.example.GestaoEscolar.model.Aula;
import com.example.GestaoEscolar.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AulaService {

    private final AulaRepository repository;
    private final AulaMapper mapper;

    public AulaService(AulaRepository repository, AulaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public AulaRespostaDTO cadastrarAula(AulaRequisicaoDTO requisicao) throws SQLException{
        Aula aula = mapper.DTOParaEntidade(requisicao);
        return mapper.EntidadeParaDTO(repository.cadastrarAula(aula));
    }

    public List<AulaRespostaDTO> listarAula() throws SQLException{
        return mapper.EntidadeParaDTOList(repository.listarAulas());
    }

    public AulaRespostaDTO procurarAulaID(int id) throws SQLException{
        return mapper.EntidadeParaDTO(repository.procurarAulaID(id));
    }

    public void atualizarAula(int id, AulaRequisicaoDTO requisicao) throws SQLException{
        Aula aula = mapper.DTOParaEntidade(requisicao);
        repository.atualizarAula(id, aula);
    }

    public void deletarAula(int id)throws SQLException{
        repository.deletarAula(id);
    }
}
