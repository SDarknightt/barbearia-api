package br.csi.barbearia.service;

import br.csi.barbearia.model.corte.Corte;
import br.csi.barbearia.model.corte.CorteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorteService {
    private CorteRepository repository;

    public CorteService(CorteRepository repository){this.repository = repository;}

    public void salvar(Corte corte){this.repository.save(corte);}
    public List<Corte> list(){return this.repository.findAll();}
    public List<Corte> listByBarbearia(Long barbeariaId) {
        return this.repository.findAllByBarbeariaId(barbeariaId);
    }
    public Corte findById(Long id){return this.repository.findById(id).orElse(null);}
    public void atualizar(Corte corte){
        Corte c = this.repository.findById(corte.getId()).orElse(null);
        if (c != null) {
            c.setNome(corte.getNome());
            c.setDescricao(corte.getDescricao());
            this.repository.save(c);
        }
    }
    public boolean excluir(Long id){
        Corte c = this.repository.findById(id).orElse(null);
        if (c != null){
            this.repository.delete(c);
            return true;
        }
        return false;
    }
}
