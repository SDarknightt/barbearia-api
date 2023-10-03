package br.csi.barbearia.model.cortes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CortesRepository extends JpaRepository<Cortes, Long> {
    public Cortes getById(Long id);
    public Optional<Cortes> findById(Long id);
    List<Cortes> findAllByBarbeariaId(Long barbeariaId);
}
