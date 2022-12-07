package br.com.masterClass.controller;

import br.com.masterClass.entity.Cpf;
import br.com.masterClass.service.CpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cpf")
public class CpfController {

    private CpfService cpfService;

    @Autowired
    public CpfController(CpfService cpfService) {
        this.cpfService = cpfService;
    }

    @PostMapping()
    public ResponseEntity<Cpf> save(@RequestBody Cpf cpf){
        return new ResponseEntity<>(cpfService.salvar(cpf),HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Cpf>> listAll(){
        return new ResponseEntity<>(cpfService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{cpfId}")
    public ResponseEntity<Optional<Cpf>> getId(@PathVariable Long cpfId){
        return new ResponseEntity<>(cpfService.listarPorId(cpfId), HttpStatus.OK);

    }

    @PutMapping("/{cpfId}")
    public ResponseEntity<Cpf> update(@PathVariable Long cpfId, @RequestBody Cpf cpf){
        return new ResponseEntity<>(cpfService.atualizar(cpfId,cpf),HttpStatus.OK);

    }

    @DeleteMapping("/{cpfId}")
    public ResponseEntity<String> deletar(@PathVariable Long cpfId){
        return new ResponseEntity<>(cpfService.delete(cpfId),HttpStatus.NO_CONTENT);

    }
}
