package cpb.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cpb.cursos.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long>{

}
