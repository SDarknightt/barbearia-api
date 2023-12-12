package br.csi.barbearia.dto;

import br.csi.barbearia.model.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FuncionarioDTO {
        private Long id;
        private String nome;
        private String cpf;
        private String telefone;
        private Endereco endereco;
}