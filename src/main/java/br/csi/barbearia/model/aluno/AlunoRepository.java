package br.csi.barbearia.model.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public Aluno getById(Long id);
    public Optional<Aluno> findById(Long id);

    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections
    @Query(value = "SELECT a.id  as id, a.nome as nome, a.matricula as matricula, a.email as email" +
            " FROM alunos a where a.idprojeto =:id", nativeQuery = true)
    List<AlunoDTO> findAlunosByProjeto(@Param("id") int id);

}
