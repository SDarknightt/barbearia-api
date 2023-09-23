package br.csi.barbearia.controller;

import br.csi.barbearia.model.barbearia.Barbearia;
import br.csi.barbearia.model.funcionario.Cliente;
import br.csi.barbearia.service.BarbeariaService;
import br.csi.barbearia.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/barbearia")
public class BarbeariaController {
    private final BarbeariaService service;
    private final ClienteService clienteService;


    public BarbeariaController(BarbeariaService service, ClienteService clienteService) {
        this.service = service;
        this.clienteService = clienteService;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Barbearia> barbearia(@PathVariable Long id) {
//        Barbearia barbearia = this.service.findById(id);
//        if (barbearia != null) {
//            return ResponseEntity.ok(barbearia);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping
    @Transactional
    public ResponseEntity<Barbearia> salvar(@RequestBody @Valid Barbearia barbearia, UriComponentsBuilder uriBuilder) {
        this.service.cadastrar(barbearia);
        URI uri = uriBuilder.path("/barbearia/{id}").buildAndExpand(barbearia.getId()).toUri();
        return ResponseEntity.created(uri).body(barbearia);
    }
    @GetMapping
    public ResponseEntity<List<Barbearia>> listar() {
        List<Barbearia> barbearias = this.service.listar();
        return ResponseEntity.ok(barbearias);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Barbearia> atualizar(@PathVariable Long id, @RequestBody Barbearia barbearia) {
        Barbearia barbeariaExistente = this.service.findById(id);
        if (barbeariaExistente != null) {
            barbearia.setId(id); // Certifique-se de definir o ID da barbearia com base no caminho
            this.service.atualizar(barbearia);
            return ResponseEntity.ok(barbearia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean barbeariaExcluida = this.service.excluir(id);
        if (barbeariaExcluida) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/clienteBarbearia/{barbeariaId}")
    public ResponseEntity<List<Cliente>> listarClientesDaBarbearia(@PathVariable Long barbeariaId) {
        List<Cliente> clientes = clienteService.findAllByBarbeariaId(barbeariaId);
        return ResponseEntity.ok(clientes);
    }

}
