package br.csi.barbearia.model.projeto;

import br.csi.barbearia.model.aluno.Aluno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "projetos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projeto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private int ano;
    private int semestre;

    @OneToMany(mappedBy = "projeto")
    @JsonIgnore
    private List<Aluno> alunos;

}
