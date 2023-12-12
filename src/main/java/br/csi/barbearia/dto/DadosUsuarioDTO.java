package br.csi.barbearia.dto;

import br.csi.barbearia.model.usuario.Usuario;

public record DadosUsuarioDTO(Long id, String login, String permissao, String telefone, String cpf, String nome) {

    public DadosUsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getLogin(), usuario.getPermissao(), usuario.getTelefone(), usuario.getCpf(), usuario.getNome());
    }
}
