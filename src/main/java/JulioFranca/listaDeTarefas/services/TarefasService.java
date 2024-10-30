package JulioFranca.listaDeTarefas.services;

import JulioFranca.listaDeTarefas.entities.Tarefas;
import JulioFranca.listaDeTarefas.exceptions.ResourceNotFoundException;
import JulioFranca.listaDeTarefas.repository.TarefasRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import JulioFranca.listaDeTarefas.exceptions.ResourceNotFoundException;


import java.util.List;

@Service
public class TarefasService {
    private TarefasRepository tarefasRepository;


    public TarefasService(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    public List<Tarefas> create(Tarefas tarefas){
        tarefasRepository.save(tarefas);
        return list();

    }

    public List<Tarefas> list(){
        Sort sort = Sort.by(Direction.DESC, "ordemApresentacao")
                .and(Sort.by(Direction.ASC, "id"));
        return tarefasRepository.findAll(sort);
    }

    public List<Tarefas> update(Long id, Tarefas tarefas) {
        tarefasRepository.findById(id).ifPresentOrElse(
                (tarefaExistente) -> {
                    tarefas.setId(id);
                    tarefasRepository.save(tarefas);
                },
                () -> {
                    throw new ResourceNotFoundException("Tarefa não encontrada com ID " + id);
                }
        );

        return list();
    }



    public List<Tarefas> delete(Long id){
        tarefasRepository.deleteById(id);
        return list();
    }


}
