package br.csi.barbearia.model.barbearia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {

    public Barbearia getById(Long id);
    public Optional<Barbearia> findById(Long id);

}
