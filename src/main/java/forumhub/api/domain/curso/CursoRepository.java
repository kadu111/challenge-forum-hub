package forumhub.api.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<forumhub.api.domain.curso.Curso, Long> {
}
