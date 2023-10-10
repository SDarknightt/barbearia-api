package br.csi.barbearia.controller;

import br.csi.barbearia.model.usuario.DadosUsuario;
import br.csi.barbearia.model.usuario.Usuario;
import br.csi.barbearia.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service){this.service =service;}

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder){
        this.service.cadastrar(usuario);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @GetMapping("/{id}")
    public DadosUsuario findById(@PathVariable Long id){
        return this.service.findUsuario(id);}

    @GetMapping
    public List<DadosUsuario> findAll(){
        return this.service.findAllUsuarios();
    }


    @GetMapping("/funcionarios/{barbeariaId}")
    public List<Usuario> listarFuncionariosDaBarbearia(@PathVariable Long barbeariaId) {
        return service.findFuncionariosByBarbeariaId(barbeariaId);
    }

}
