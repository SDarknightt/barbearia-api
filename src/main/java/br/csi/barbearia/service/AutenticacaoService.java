package br.csi.barbearia.service;

import br.csi.barbearia.model.usuario.Usuario;
import br.csi.barbearia.model.usuario.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    private final UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository){ this.repository = repository; }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        Usuario usuario = this.repository.findByLogin(login);
        if(usuario==null){
            throw new UsernameNotFoundException("Usuário ou Senha incorretos");
        }else{
            UserDetails user = User.withUsername(usuario.getLogin()).password(usuario.getSenha()).authorities(usuario.getPermissao()).build();
            return user;
        }
    }
}
