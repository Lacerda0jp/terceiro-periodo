package br.com.terceiroperiodo.controller;

import br.com.terceiroperiodo.model.Estado;
import br.com.terceiroperiodo.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estado") //é a URL QUE VAI TORNAR SEU SISTEMA DISPONÍVEL

public class EstadoController {
    @Autowired
    EstadoService estadoService;

    @PostMapping()
    public ResponseEntity<Estado> salvarEstado(@RequestBody Estado estado) {
        Estado response = estadoService.salvar(estado);
        return ResponseEntity.ok(response);
    }
        @GetMapping(path = "/all", produces = "application/json")
        public ResponseEntity<List<Estado>> buscarTodos() {
            List<Estado> response = estadoService.buscarTodos();
            return ResponseEntity.ok(response);
        }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Estado> buscarPorID(@PathVariable Long id) {

        Optional<Estado> response = estadoService.buscarPorID(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path="/nome/{nome}")
    public ResponseEntity<List<Estado>> buscarPorNome(@PathVariable String nome){
        List<Estado> response= estadoService.buscarPorNome(nome);
        if (response != null && !response.isEmpty()){
            return ResponseEntity.ok(response);
        }

        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (!estadoService.buscarPorID(id).isPresent()){
         return ResponseEntity.notFound().build();

        }
        estadoService.deleteByid(id);
        return ResponseEntity.noContent().build();
    }

}