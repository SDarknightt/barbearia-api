package br.csi.barbearia.service;

import br.csi.barbearia.model.aluno.AlunoDTO;
import br.csi.barbearia.model.projeto.Projeto;
import br.csi.barbearia.model.projeto.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;

    public ProjetoService(ProjetoRepository repository){
        this.repository = repository;
    }

    public void salvar(Projeto projeto){
        this.repository.save(projeto);
    }


    public List<Projeto> listar(){
        return this.repository.findAll();
    }

    public List<AlunoDTO> listarAlunos(int idProjeto){
        return this.repository.findAlunosByProjeto(idProjeto);
    }

}
