package com.example.GestaoEscolar.service;

import com.example.GestaoEscolar.dto.CursoDTO.CursoRequisicaoDTO;
import com.example.GestaoEscolar.dto.CursoDTO.CursoRespostaDTO;
import com.example.GestaoEscolar.mapper.CursoMapper;
import com.example.GestaoEscolar.model.Curso;
import com.example.GestaoEscolar.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;
    private final CursoMapper mapper;

    public CursoService(CursoRepository repository, CursoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public CursoRespostaDTO cadastrarCurso(CursoRequisicaoDTO requisicao) throws SQLException{
        Curso curso = mapper.DTOParaEntidade(requisicao);
        return mapper.EntidadeParaDTO(repository.cadastrarCurso(curso));
    }

    public List<CursoRespostaDTO> listarCursos() throws SQLException{
        return mapper.EntidadeParaDTOList(repository.listarCursos());
    }

    public CursoRespostaDTO procurarCursoID(int id) throws SQLException{
        return mapper.EntidadeParaDTO(repository.procurarCursoID(id));
    }

    public void atualizarCurso(int id, CursoRequisicaoDTO requisicao) throws SQLException{
        Curso curso = mapper.DTOParaEntidade(requisicao);
        repository.atualizarCurso(id, curso);
    }

    public void deletarCurso(int id) throws SQLException{
        repository.deletarCurso(id);
    }
}
