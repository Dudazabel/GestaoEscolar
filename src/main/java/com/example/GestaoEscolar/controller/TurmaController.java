package com.example.GestaoEscolar.controller;

import com.example.GestaoEscolar.dto.TurmaDTO.TurmaRequisicaoDTO;
import com.example.GestaoEscolar.dto.TurmaDTO.TurmaRespostaDTO;
import com.example.GestaoEscolar.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class TurmaController {
    private final TurmaService service;

    public TurmaController(TurmaService service){
        this.service = service;
    }

    @PostMapping
    public TurmaRespostaDTO cadastrarTurma(@Valid @RequestBody TurmaRequisicaoDTO requisicao){
        try{
            return service.cadastrarTurma(requisicao);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<TurmaRespostaDTO> listarTurma(){
        try{
            return service.listarTurmas();
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public TurmaRespostaDTO procurarTurmaID(@PathVariable int id){
        try{
            return service.procurarTurmaID(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void atualizarTurma(@PathVariable int id, @Valid @RequestBody TurmaRequisicaoDTO requisicao){
        try{
            service.atualizarTurma(id, requisicao);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarTurma(@PathVariable int id){
        try{
            service.deletarTurma(id);
        }catch(SQLException e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
