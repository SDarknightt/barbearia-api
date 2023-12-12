package br.csi.barbearia.controller;

import br.csi.barbearia.dto.AgendamentosBarbeariaDTO;
import br.csi.barbearia.model.agendamento.Agendamento;
import br.csi.barbearia.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {this.service = service;}

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> agendamento(@PathVariable Long id){
        Agendamento agendamento = this.service.findById(id);
        if(agendamento != null){
            return ResponseEntity.ok(agendamento);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    @Transactional
    public ResponseEntity<Agendamento> salvar(@RequestBody Agendamento agendamento, UriComponentsBuilder uriBuilder){
        this.service.salvar(agendamento);
        URI uri = uriBuilder.path("/agendamento/{id}").buildAndExpand(agendamento.getId()).toUri();
        return ResponseEntity.created(uri).body(agendamento);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listar(){
        List<Agendamento> agendamentos = this.service.listar();
        return ResponseEntity.ok(agendamentos);
    }

    @PutMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody Agendamento agendamento){
        Agendamento agendamentoExistente = this.service.findById(id);
        if (agendamentoExistente != null){
            agendamento.setId(id);
            this.service.atualizar(agendamento);
            return ResponseEntity.ok(agendamento);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        boolean agendamentoExcluido= this.service.excluir(id);
        if (agendamentoExcluido){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("barbearia/{barbeariaId}")
    public ResponseEntity<List<AgendamentosBarbeariaDTO>> listarPorBarbearia(@PathVariable Long barbeariaId) {
        List<AgendamentosBarbeariaDTO> agendamentos = this.service.listarPorBarbearia(barbeariaId);
        return ResponseEntity.ok(agendamentos);
    }

}
