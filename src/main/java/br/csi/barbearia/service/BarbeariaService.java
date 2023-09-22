package br.csi.barbearia.service;

import br.csi.barbearia.model.barbearia.Barbearia;
import br.csi.barbearia.model.barbearia.BarbeariaDTO;
import br.csi.barbearia.model.barbearia.BarbeariaRepository;
import br.csi.barbearia.model.projeto.Projeto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeariaService {
    private BarbeariaRepository repository;

    public BarbeariaService(BarbeariaRepository repository) {
        this.repository = repository;
    }

    public void salvar(Barbearia barbearia) {
        this.repository.save(barbearia);
    }

    public List<Barbearia> listar() {
        return this.repository.findAll();
    }

    public Barbearia findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public void atualizar(Barbearia barbearia) {
        Barbearia b = this.repository.findById(barbearia.getId()).orElse(null);
        if (b != null) {
            b.setNome(barbearia.getNome());
            b.setEndereco(barbearia.getEndereco());
            // Adicione outras atualizações de campos conforme necessário
            this.repository.save(b);
        }
    }

    public boolean excluir(Long id) {
        Barbearia b = this.repository.findById(id).orElse(null);
        if (b != null) {
            this.repository.delete(b);
            return true;
        }
        return false;
    }
}
