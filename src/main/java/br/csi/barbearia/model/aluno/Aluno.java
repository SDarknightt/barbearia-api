package br.csi.barbearia.model.aluno;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Size(max = 8, message = "Matricula deve ter no máximo 8 digitos")
    private String matricula;
    @Email(message = "Email inválido")
    private String email;
    @Embedded
    private Endereco endereco;
}
