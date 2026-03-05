package com.example.GestaoEscolar.controller;

import com.example.GestaoEscolar.dto.NotaDTO.NotaRequisicaoDTO;
import com.example.GestaoEscolar.dto.NotaDTO.NotaRespostaDTO;
import com.example.GestaoEscolar.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class NotaController {

    private final NotaService service;

    public NotaController(NotaService service){
        this.service = service;
    }

    @PostMapping
    public NotaRespostaDTO cadastrarNota(@Valid @RequestBody NotaRequisicaoDTO requisicao){
        try{
            return service.cadastrarNota(requisicao);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<NotaRespostaDTO> listarNotas(){
        try{
            return service.listarNotas();
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public NotaRespostaDTO procurarNotaID(@PathVariable int id){
        try{
            return service.procurarNotaID(id);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/{id}")
    public void atualizarNota(@PathVariable int id, @Valid @RequestBody NotaRequisicaoDTO requisicao){
        try{
            service.atualizarNota(id, requisicao);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarNota(@PathVariable int id){
        try{
            service.deletarNota(id);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
