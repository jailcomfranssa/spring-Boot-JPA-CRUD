package br.com.masterClass.controller;

import br.com.masterClass.entity.Ordem;
import br.com.masterClass.service.OrdemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordens")
public class OrdemController {

    private final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);

    private final OrdemService ordemService;

    public OrdemController(OrdemService ordemService) {
        this.ordemService = ordemService;
    }

    @PostMapping()
    public ResponseEntity<Ordem> salvar(@RequestBody Ordem ordem){
        LOGGER.info("Criando Ordem de compras...");
        return new ResponseEntity<>(ordemService.salvar(ordem), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Ordem>> getAll(){
        LOGGER.info("Listar Todos");
        return new ResponseEntity<>(ordemService.listarTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ordem>> getById(@PathVariable Long id){
        LOGGER.info("Listar Por Id");
        return new ResponseEntity<>(ordemService.buscarPorId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ordem> update(@PathVariable Long id, @RequestBody Ordem ordem){
        LOGGER.info("Atualizando Ordem...");
        return new ResponseEntity<>(ordemService.atualizar(id,ordem),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        LOGGER.info("Deletar Ordem...");
        ordemService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
