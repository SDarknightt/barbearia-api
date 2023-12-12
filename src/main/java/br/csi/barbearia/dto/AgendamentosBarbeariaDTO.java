package br.csi.barbearia.dto;

import br.csi.barbearia.model.cliente.Cliente;
import br.csi.barbearia.model.corte.Corte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class AgendamentosBarbeariaDTO {
    private Long id;
    private Cliente cliente;
    private Corte corte;
    private Date datacorte;
}
