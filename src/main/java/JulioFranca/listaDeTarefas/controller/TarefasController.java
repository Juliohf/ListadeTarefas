package JulioFranca.listaDeTarefas.controller;

import JulioFranca.listaDeTarefas.entities.Tarefas;
import JulioFranca.listaDeTarefas.exceptions.ResourceNotFoundException;
import JulioFranca.listaDeTarefas.services.TarefasService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    private TarefasService tarefasService;

    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @PostMapping
    List<Tarefas> create(@RequestBody Tarefas tarefas){
        return tarefasService.create(tarefas);
    }

    @GetMapping
    List<Tarefas> list(){
        return tarefasService.list();
    }

    @PutMapping("{id}")
    List<Tarefas> update(@PathVariable Long id, @RequestBody Tarefas tarefas) throws ResourceNotFoundException {
        return tarefasService.update(id, tarefas);
    }

    @DeleteMapping("/{id}")
    List<Tarefas> delete(@PathVariable("id") Long id){
        return tarefasService.delete(id);
    }
}
