package br.csi.barbearia.controller;

import br.csi.barbearia.dto.CorteDTO;
import br.csi.barbearia.model.corte.Corte;
import br.csi.barbearia.service.CorteService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/corte")
public class CorteController {
    private final CorteService service;
    public CorteController(CorteService service){this.service = service;}

    @GetMapping("/{id}")
    public ResponseEntity<Corte> corte(@PathVariable Long id) {
        Corte corte = this.service.findById(id);
        if (corte != null) {
            return ResponseEntity.ok(corte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Corte> salvar(@RequestBody Corte corte, UriComponentsBuilder uriBuilder){
        this.service.salvar(corte);
        URI uri = uriBuilder.path("/corte/{id}").buildAndExpand(corte.getId()).toUri();
        return ResponseEntity.created(uri).body(corte);
    }

    @GetMapping("/cortes")
    public ResponseEntity<List<Corte>> list(){
        List<Corte> cortes = this.service.list();
        return ResponseEntity.ok(cortes);
    }

    @GetMapping("/barbearia/{barbeariaId}")
    public List<CorteDTO> getCortesByBarbeariaId(@PathVariable Long barbeariaId) {
        return service.listByBarbearia(barbeariaId);
    }

    @PutMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity<Corte> atualizar(@PathVariable Long id, @RequestBody Corte corte) {
        Corte corteExistente = this.service.findById(id);
        if (corteExistente != null) {
            corte.setId(id); // Certifique-se de definir o ID do corte com base no caminho
            this.service.atualizar(corte);
            return ResponseEntity.ok(corte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean corteExcluido = this.service.excluir(id);
        if (corteExcluido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
