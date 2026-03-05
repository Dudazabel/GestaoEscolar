package com.example.GestaoEscolar.controller;

import com.example.GestaoEscolar.dto.AlunoDTO.AlunoRequisicaoDTO;
import com.example.GestaoEscolar.dto.AlunoDTO.AlunoRespostaDTO;
import com.example.GestaoEscolar.dto.TurmaDTO.TurmaRequisicaoDTO;
import com.example.GestaoEscolar.dto.TurmaDTO.TurmaRespostaDTO;
import com.example.GestaoEscolar.service.AlunoService;
import com.example.GestaoEscolar.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class AlunoController {

    private final AlunoService service;


    public AlunoController(AlunoService service){
        this.service = service;
    }

    @PostMapping
    public AlunoRespostaDTO cadastrarAluno(@Valid @RequestBody AlunoRequisicaoDTO requisicao){
        try{
            return service.cadastrarAluno(requisicao);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<AlunoRespostaDTO> listarAlunos(){
        try{
            return service.listaAlunos();
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public AlunoRespostaDTO procurarAlunoID(@PathVariable int id){
        try{
            return service.procurarAlunoID(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void atualizarAluno(@PathVariable int id,@Valid @RequestBody AlunoRequisicaoDTO requisicao){
        try{
            service.atualizarAluno(id, requisicao);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable int id){
        try{
            service.deletarAluno(id);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
