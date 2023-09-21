package br.csi.barbearia.service;

import br.csi.barbearia.model.aluno.Aluno;
import br.csi.barbearia.model.aluno.AlunoDTO;
import br.csi.barbearia.model.aluno.AlunoRepository;
import br.csi.barbearia.model.projeto.Projeto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private AlunoRepository repository;
    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }
    public void salvar(Aluno aluno){
        this.repository.save(aluno);
    }
    public List<Aluno> listar(){
        return this.repository.findAll();
    }
    public Aluno findById(Long id){
        return this.repository.findById(id).get();
    }
    /*
    Para atualizar uma entidade do banco é necessário pegar a referencia desta
    e atualizar com os dados que vieram por parametro.
    O Save detecta que é uma entidade que já existe no banco por ter um ID e dados modificados
    e faz um update
    * */
    public void atualizar(Aluno aluno){
        Aluno a = this.repository.getReferenceById(aluno.getId());
        a.setNome(aluno.getNome());
        a.setEmail(aluno.getEmail());
        a.setMatricula(aluno.getMatricula());
        a.setEndereco(aluno.getEndereco());
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public String atribuirProjeto(Long idAluno, Projeto projeto){
        Aluno aluno = this.repository.getReferenceById(idAluno);
        aluno.setProjeto(projeto);
       return "Projeto atribuído com sucesso";
    }

    public List<AlunoDTO> findByAlunosPorProjeto(int id){
        return this.repository.findAlunosByProjeto(id);
    }

}
