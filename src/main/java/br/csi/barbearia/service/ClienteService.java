package br.csi.barbearia.service;

import br.csi.barbearia.dto.ClienteBarbeariaDTO;
import br.csi.barbearia.dto.ClienteDTO;
import br.csi.barbearia.model.cliente.Cliente;
import br.csi.barbearia.model.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void salvar(Cliente cliente) {
        this.repository.save(cliente);
    }

    public List<Cliente> listar() {
        return this.repository.findAll();
    }

    public Cliente findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public void atualizar(Cliente cliente) {
        Cliente c = this.repository.findById(cliente.getId()).orElse(null);
        if (c != null) {
            c.setNome(cliente.getNome());
            c.setEmail(cliente.getEmail());
            c.setTelefone(cliente.getTelefone());
            this.repository.save(c);
        }
    }

    public boolean excluir(Long id) {
        Cliente c = this.repository.findById(id).orElse(null);
        if (c != null) {
            this.repository.delete(c);
            return true;
        }
        return false;
    }

    public List<ClienteDTO> findAllByBarbeariaId(Long barbeariaId) {
        return repository.findAllClientesByBarbeariaId(barbeariaId);
    }

    public List<ClienteBarbeariaDTO> listarClientesPorBarbearia(Long barbeariaId) {
        return repository.findByBarbeariaId(barbeariaId);
    }

}
