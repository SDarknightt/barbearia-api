package br.csi.barbearia.controller;

import br.csi.barbearia.dto.ClienteBarbeariaDTO;
import br.csi.barbearia.dto.ClienteDTO;
import br.csi.barbearia.model.cliente.Cliente;
import br.csi.barbearia.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> cliente(@PathVariable Long id) {
        Cliente cliente = this.service.findById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente, UriComponentsBuilder uriBuilder) {
        this.service.salvar(cliente);
        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = this.service.listar();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteExistente = this.service.findById(id);
        if (clienteExistente != null) {
            cliente.setId(id); // Certifique-se de definir o ID do cliente com base no caminho
            this.service.atualizar(cliente);
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean clienteExcluido = this.service.excluir(id);
        if (clienteExcluido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/barbearia/{barbeariaId}")
    public ResponseEntity<List<ClienteBarbeariaDTO>> listarClientesPorBarbearia(@PathVariable Long barbeariaId) {
        List<ClienteBarbeariaDTO> clientes = this.service.listarClientesPorBarbearia(barbeariaId);
        return ResponseEntity.ok(clientes);
    }

}
