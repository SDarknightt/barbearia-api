package br.csi.barbearia.model.usuario;

import br.csi.barbearia.model.barbearia.Barbearia;
import br.csi.barbearia.model.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    private String login;

    @NotNull
    private String senha;

    @NotNull
    private String permissao;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    private String nome;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "barbeariaid")
    private Barbearia barbearia;

    @Embedded
    private Endereco endereco;

}
