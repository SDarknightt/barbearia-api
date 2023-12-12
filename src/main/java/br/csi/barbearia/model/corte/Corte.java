package br.csi.barbearia.model.corte;

import br.csi.barbearia.model.barbearia.Barbearia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "corte")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Corte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotBlank
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "barbeariaid")
    private Barbearia barbearia;
}
