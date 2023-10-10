package br.csi.barbearia.model.agendamento;

import br.csi.barbearia.model.barbearia.Barbearia;
import br.csi.barbearia.model.corte.Corte;
import br.csi.barbearia.model.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @JoinColumn(name = "corteid")
    private Corte corte;
}
