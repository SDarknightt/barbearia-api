package br.csi.barbearia.model.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public Funcionario getById(Long id);
    public Optional<Funcionario> findById(Long id);
    List<Funcionario> findAllByBarbeariaId(Long barbeariaId);


}
