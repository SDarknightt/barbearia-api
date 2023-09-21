package br.csi.barbearia.controller;

import br.csi.barbearia.model.aluno.AlunoDTO;
import br.csi.barbearia.model.projeto.Projeto;
import br.csi.barbearia.service.ProjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(ProjetoService service){
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Projeto> salvar(@RequestBody Projeto projeto, UriComponentsBuilder uriBuilder){
        this.service.salvar(projeto);
        //monta a URI da aplicação dinamicamente
        URI uri = uriBuilder.path("/projeto/{id}").buildAndExpand(projeto.getId()).toUri();
        //created(uri) irá colocar no cabeçalho da requisição da resposta
        // o parâmetro Location com a URI de acesso ao recurso criado
        return ResponseEntity.created(uri).body(projeto);
    }

    @GetMapping
    public List<Projeto> listar(){
        return this.service.listar();
    }

    @GetMapping("/{id}/alunos")
    public List<AlunoDTO> listarAlunos(@PathVariable int id){
        return this.service.listarAlunos(id);
    }

}
