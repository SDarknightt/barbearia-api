package br.csi.barbearia.model.funcionario;

import br.csi.barbearia.model.aluno.Endereco;
import br.csi.barbearia.model.barbearia.Barbearia;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @Email(message = "Email inválido")
    private String email;

    @NotBlank
    private String nome;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "barbeariaid")
    private Barbearia barbearia;

    @Embedded
    private Endereco endereco;
}
