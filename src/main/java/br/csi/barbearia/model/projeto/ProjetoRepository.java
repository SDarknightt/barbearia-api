package br.csi.barbearia.model.projeto;

import br.csi.barbearia.model.aluno.AlunoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections
        @Query(value = "SELECT a.id  as id, a.nome as nome, a.matricula as matricula, a.email as email" +
                " FROM alunos a where a.idprojeto =:id", nativeQuery = true)
        List<AlunoDTO> findAlunosByProjeto(@Param("id") int id);


}
