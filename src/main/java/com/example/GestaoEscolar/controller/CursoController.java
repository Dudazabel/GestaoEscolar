package com.example.GestaoEscolar.controller;

import com.example.GestaoEscolar.dto.CursoDTO.CursoRequisicaoDTO;
import com.example.GestaoEscolar.dto.CursoDTO.CursoRespostaDTO;
import com.example.GestaoEscolar.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CursoController {


    private final CursoService service;

    public CursoController(CursoService service){
        this.service = service;
    }

    @PostMapping
    public CursoRespostaDTO cadastrarCurso(@Valid @RequestBody CursoRequisicaoDTO requisicao){
        try{
            return service.cadastrarCurso(requisicao);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<CursoRespostaDTO> listarCursos(){
        try{
            return service.listarCursos();
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public CursoRespostaDTO procurarCursoID(@PathVariable int id){
        try{
            return service.procurarCursoID(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void atualizarCurso(@PathVariable int id, @Valid @RequestBody CursoRequisicaoDTO requisicao){
        try{
            service.atualizarCurso(id, requisicao);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable int id){
        try{
            service.deletarCurso(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
