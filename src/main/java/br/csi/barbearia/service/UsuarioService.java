package br.csi.barbearia.service;

import br.csi.barbearia.model.corte.Corte;
import br.csi.barbearia.model.usuario.DadosUsuario;
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
    public DadosUsuario findUsuario(Long id)
    {
        Usuario usuario = this.repository.getReferenceById(id);
        return new DadosUsuario(usuario);
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
    public List<DadosUsuario> findAllUsuarios(){
        return this.repository.findAll().stream().map(DadosUsuario::new).toList();
    }

    public List<Usuario> findFuncionariosByBarbeariaId(Long barbeariaId) {
        return repository.findByBarbeariaIdAndPermissao(barbeariaId, "ROLE_FUNCIONARIO");
    }
//    public record DadosUsuario(Long id, String login, String permissao){
//        public DadosUsuario(Usuario usuario){
//            this(usuario.getId(), usuario.getLogin(), usuario.getPermissao());
//        }
//    }
}
