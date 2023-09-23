package br.csi.barbearia.dto;

import br.csi.barbearia.model.usuario.Usuario;

public record DadosUsuario(Long id, String login, String permissao){
        public DadosUsuario(Usuario usuario){
            this(usuario.getId(), usuario.getLogin(), usuario.getPermissao());
        }
    }