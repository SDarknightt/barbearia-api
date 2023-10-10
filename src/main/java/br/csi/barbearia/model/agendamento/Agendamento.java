package br.csi.barbearia.model.agendamento;

import br.csi.barbearia.model.barbearia.Barbearia;
import br.csi.barbearia.model.corte.Corte;
import br.csi.barbearia.model.usuario.Usuario;
import br.csi.barbearia.model.cliente.Cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuarioid")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "barbeariaid")
    private Barbearia barbearia;

    @ManyToOne
    @JoinColumn(name = "clienteid")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "corteid")
    private Corte corte;
}
