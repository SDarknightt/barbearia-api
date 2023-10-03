package br.csi.barbearia.model.cortes;

import br.csi.barbearia.model.barbearia.Barbearia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cortes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cortes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "barbeariaid")
    private Barbearia barbearia;
}
