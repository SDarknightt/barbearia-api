package br.csi.barbearia.model.barbearia;

import br.csi.barbearia.model.aluno.Aluno;
import br.csi.barbearia.model.aluno.AlunoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {

    public Barbearia getById(Long id);
    public Optional<Barbearia> findById(Long id);


}
