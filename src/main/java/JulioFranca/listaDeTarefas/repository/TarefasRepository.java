package JulioFranca.listaDeTarefas.repository;

import JulioFranca.listaDeTarefas.entities.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}
