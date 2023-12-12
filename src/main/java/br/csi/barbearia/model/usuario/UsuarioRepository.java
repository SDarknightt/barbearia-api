package br.csi.barbearia.model.usuario;

import br.csi.barbearia.dto.FuncionarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    public Usuario findByLogin(String login);
    Usuario findById(long id);

    List<FuncionarioDTO> findByBarbeariaIdAndPermissao(Long barbeariaId, String permissao);

}
