package com.example.GestaoEscolar.controller;

import com.example.GestaoEscolar.dto.AulaDTO.AulaRequisicaoDTO;
import com.example.GestaoEscolar.dto.AulaDTO.AulaRespostaDTO;
import com.example.GestaoEscolar.service.AulaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class AulaController {

    private final AulaService service;

    public AulaController(AulaService service){
        this.service = service;
    }

    @PostMapping
    public AulaRespostaDTO cadastrarAula(@Valid @RequestBody AulaRequisicaoDTO requisicao){
        try{
            return service.cadastrarAula(requisicao);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<AulaRespostaDTO> listarAulas(){
        try{
            return service.listarAula();
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public AulaRespostaDTO procurarAlunoID(@PathVariable int id){
        try{
            return service.procurarAulaID(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void atualizarAula(@PathVariable int id, @Valid @RequestBody AulaRequisicaoDTO requisicao){
        try{
            service.atualizarAula(id, requisicao);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarAula(@PathVariable int id){
        try{
            service.deletarAula(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
