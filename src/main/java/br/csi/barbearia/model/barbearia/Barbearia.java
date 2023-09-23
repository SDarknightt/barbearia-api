package br.csi.barbearia.model.barbearia;

import br.csi.barbearia.model.aluno.Endereco;
import br.csi.barbearia.model.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
