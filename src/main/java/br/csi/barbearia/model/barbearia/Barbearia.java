package br.csi.barbearia.model.barbearia;

import br.csi.barbearia.model.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "barbearias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Barbearia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @NotBlank
    private String cnpj;

    @Email(message = "Email inválido")
    private String email;

    private String telefone;

    @Embedded
    private Endereco endereco;

}
