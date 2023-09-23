package br.csi.barbearia.model.funcionario;

import br.csi.barbearia.model.barbearia.Barbearia;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Email inválido")
    private String email;

    @NotBlank
    private String nome;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "barbeariaid")
    private Barbearia barbearia;

}
