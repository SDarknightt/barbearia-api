package br.csi.barbearia.model.cliente;

import br.csi.barbearia.dto.ClienteBarbeariaDTO;
import br.csi.barbearia.dto.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente getById(Long id);
    public Optional<Cliente> findById(Long id);
    List<ClienteDTO> findAllClientesByBarbeariaId(Long barbeariaId);

    List<ClienteBarbeariaDTO> findByBarbeariaId(Long barbeariaId);

}
