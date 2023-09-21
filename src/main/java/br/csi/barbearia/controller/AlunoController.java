package br.csi.barbearia.controller;

import br.csi.barbearia.model.aluno.Aluno;
import br.csi.barbearia.model.aluno.AlunoDTO;
import br.csi.barbearia.model.projeto.Projeto;
import br.csi.barbearia.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoService service;
    public AlunoController(AlunoService service){
        this.service = service;
    }
    @PostMapping("/print-json")
    public void printJSon(@RequestBody String json){
        System.out.println(json);
    }

    @GetMapping("/{id}")
    public Aluno aluno(@PathVariable Long id){
        return this.service.findById(id);
    }


    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid Aluno aluno, UriComponentsBuilder uriBuilder){

        this.service.salvar(aluno);
        //monta a URI da aplicação dinamicamente
        URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
        //created(uri) irá colocar no cabeçalho da requisição da resposta
        // o parâmetro Location com a URI de acesso ao recurso criado
        return ResponseEntity.created(uri).body(aluno);
    }


    @GetMapping
    public ResponseEntity<List<Aluno>> listar(){
        return ResponseEntity.ok(this.service.listar());
    }


    /*
     ATUALIZAR DEVE DEVOLVER O RECURSO ATUALIZADO
     Mas não é boa prática devolver a entidade JPA no controler;

    * */
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Aluno aluno){
        this.service.atualizar(aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atribuir-projeto")
    @Transactional
    public ResponseEntity vincularProjeto(@PathVariable Long id, @RequestBody Projeto projeto){
        return ResponseEntity.ok(this.service.atribuirProjeto(id, projeto));
    }

    @GetMapping("/projeto/{id}")
    public List<AlunoDTO> listarAlunos(@PathVariable int id){
        return this.service.findByAlunosPorProjeto(id);
    }

}


