package br.csi.barbearia.controller;

import br.csi.barbearia.model.funcionario.Funcionario;
import br.csi.barbearia.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping("/print-json")
    public void printJSon(@RequestBody String json) {
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> funcionario(@PathVariable Long id) {
        Funcionario funcionario = this.service.findById(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("funcionarioBarbearia/{barbeariaId}")
    public ResponseEntity<List<Funcionario>> listarFuncionariosDaBarbearia(@PathVariable Long barbeariaId) {
        List<Funcionario> funcionarios = service.findAllByBarbeariaId(barbeariaId);
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario, UriComponentsBuilder uriBuilder) {
        this.service.salvar(funcionario);
        URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        List<Funcionario> funcionarios = this.service.listar();
        return ResponseEntity.ok(funcionarios);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioExistente = this.service.findById(id);
        if (funcionarioExistente != null) {
            funcionario.setId(id); // Certifique-se de definir o ID do funcionário com base no caminho
            this.service.atualizar(funcionario);
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean funcionarioExcluido = this.service.excluir(id);
        if (funcionarioExcluido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
