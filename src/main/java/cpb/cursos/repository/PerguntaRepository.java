package cpb.cursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cpb.cursos.model.Categoria;
import cpb.cursos.model.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{

	List<Pergunta> findByCategoria(Categoria categoria);

}
