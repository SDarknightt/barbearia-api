package br.csi.barbearia.model.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    public Agendamento getById(Long id);
    public Optional<Agendamento> findById(Long id);
    List<Agendamento> findAllAgendamentosByBarbeariaId(Long barbeariaId);
}
