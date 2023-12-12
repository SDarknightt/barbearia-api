package br.csi.barbearia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteBarbeariaDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
}
