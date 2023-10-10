package br.csi.barbearia.model.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente getById(Long id);
    public Optional<Cliente> findById(Long id);
    List<Cliente> findAllClientesByBarbeariaId(Long barbeariaId);

    List<Cliente> findByBarbeariaId(Long barbeariaId);

}
