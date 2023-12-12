package br.csi.barbearia.dto;

import br.csi.barbearia.model.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO {
        private Long id;
        private String nome;
        private String telefone;
        private String email;
}