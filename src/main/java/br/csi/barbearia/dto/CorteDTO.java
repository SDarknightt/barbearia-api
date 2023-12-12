package br.csi.barbearia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CorteDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
