package br.csi.barbearia.service;

import br.csi.barbearia.model.funcionario.Funcionario;
import br.csi.barbearia.model.funcionario.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }


    public List<Funcionario> findAllByBarbeariaId(Long barbeariaId) {
        return repository.findAllByBarbeariaId(barbeariaId);
    }

    public void salvar(Funcionario funcionario) {
        this.repository.save(funcionario);
    }

    public List<Funcionario> listar() {
        return this.repository.findAll();
    }

    public Funcionario findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public void atualizar(Funcionario funcionario) {
        Funcionario f = this.repository.findById(funcionario.getId()).orElse(null);
        if (f != null) {
            f.setNome(funcionario.getNome());
            f.setEmail(funcionario.getEmail());
            f.setCpf(funcionario.getCpf());
            f.setTelefone(funcionario.getTelefone());
            f.setEndereco(funcionario.getEndereco());
            // Adicione outras atualizações de campos conforme necessário
            this.repository.save(f);
        }
    }

    public boolean excluir(Long id) {
        Funcionario f = this.repository.findById(id).orElse(null);
        if (f != null) {
            this.repository.delete(f);
            return true;
        }
        return false;
    }
}
