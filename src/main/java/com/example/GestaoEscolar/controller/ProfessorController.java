package com.example.GestaoEscolar.controller;

import com.example.GestaoEscolar.dto.ProfessorDTO.ProfessorRequisicaoDTO;
import com.example.GestaoEscolar.dto.ProfessorDTO.ProfessorRespostaDTO;
import com.example.GestaoEscolar.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service){
        this.service = service;
    }

    @PostMapping
    public ProfessorRespostaDTO cadastrarProfessor(@Valid @RequestBody ProfessorRequisicaoDTO requisicao){
        try{
            return service.cadastrarProfessor(requisicao);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<ProfessorRespostaDTO> listarProfessores(){
        try{
            return service.listarProfessores();
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ProfessorRespostaDTO procurarProfessorID(@PathVariable int id){
        try{
            return service.procurarProfessorID(id);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void atualizarProfessor(@PathVariable int id, @Valid @RequestBody ProfessorRequisicaoDTO requisicao){
        try{
            service.atualizarProfessor(id, requisicao);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable int id){
        try{
            service.deletarProfessor(id);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
