package br.csi.barbearia.service;

import br.csi.barbearia.model.agendamento.Agendamento;
import br.csi.barbearia.model.agendamento.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {
    private AgendamentoRepository repository;
    public AgendamentoService(AgendamentoRepository repository){this.repository = repository;}

    public void salvar(Agendamento agendamento){this.repository.save(agendamento);}
    public List<Agendamento> listar(){return this.repository.findAll();}
    public Agendamento findById(Long id){return this.repository.findById(id).orElse(null);}
    public void atualizar(Agendamento agendamento){
        Agendamento a = this.repository.findById(agendamento.getId()).orElse(null);
        if(a != null){
            a.setDescricao(agendamento.getDescricao());
            a.setCorte(agendamento.getCorte());
            this.repository.save(a);
        }
    }
    public boolean excluir(Long id){
        Agendamento a = this.repository.findById(id).orElse(null);
        if(a != null){
            this.repository.delete(a);
            return true;
        }
        return false;
    }

    public List<Agendamento> listarPorBarbearia(Long barbeariaId) {
        return this.repository.findByBarbeariaId(barbeariaId);
    }
}
