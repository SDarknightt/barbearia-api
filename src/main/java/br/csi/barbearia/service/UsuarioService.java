package br.csi.barbearia.service;

import br.csi.barbearia.dto.DadosUsuarioDTO;
import br.csi.barbearia.dto.FuncionarioDTO;
import br.csi.barbearia.model.usuario.Usuario;
import br.csi.barbearia.model.usuario.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public void cadastrar(Usuario usuario){
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        this.repository.save(usuario);
    }
    public Usuario findById(Long id){return this.repository.findById(id).orElse(null);}
    public DadosUsuarioDTO findUsuario(Long id)
    {
        Usuario usuario = this.repository.getReferenceById(id);
        return new DadosUsuarioDTO(usuario);
    }

    public void atualizar(Usuario usuario){
        Usuario u = this.repository.findById(usuario.getId()).orElse(null);
        if (u != null) {
            u.setLogin(usuario.getLogin());
            u.setSenha(usuario.getSenha());
            u.setPermissao(usuario.getPermissao());
            u.setCpf(usuario.getCpf());
            u.setNome(usuario.getNome());
            u.setTelefone(usuario.getTelefone());
            u.setEndereco(usuario.getEndereco());
            this.repository.save(u);
        }
    }

    public boolean excluir(Long id){
        Usuario u = this.repository.findById(id).orElse(null);
        if (u != null){
            this.repository.delete(u);
            return true;
        }
        return false;
    }
    public List<DadosUsuarioDTO> findAllUsuarios(){
        return this.repository.findAll().stream().map(DadosUsuarioDTO::new).toList();
    }

    public List<FuncionarioDTO> findFuncionariosByBarbeariaId(Long barbeariaId) {
        return repository.findByBarbeariaIdAndPermissao(barbeariaId, "ROLE_FUNCIONARIO");
    }
//    public record DadosUsuario(Long id, String login, String permissao){
//        public DadosUsuario(Usuario usuario){
//            this(usuario.getId(), usuario.getLogin(), usuario.getPermissao());
//        }
//    }
}
