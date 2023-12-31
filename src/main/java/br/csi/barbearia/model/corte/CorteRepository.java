package br.csi.barbearia.model.corte;

import br.csi.barbearia.dto.CorteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CorteRepository extends JpaRepository<Corte, Long> {
    public Corte getById(Long id);
    public Optional<Corte> findById(Long id);
    List<CorteDTO> findAllByBarbeariaId(Long barbeariaId);;
}
