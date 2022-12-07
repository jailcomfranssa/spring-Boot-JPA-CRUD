package br.com.masterClass.controller;

import br.com.masterClass.entity.Pessoa;
import br.com.masterClass.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping()
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
        return new ResponseEntity<>(pessoaService.salvar(pessoa),HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<List<Pessoa>> listAll(){
        return new ResponseEntity<>(pessoaService.litar(), HttpStatus.OK);
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<Optional<Pessoa>> getId(@PathVariable Long pessoaId){
        return new ResponseEntity<>(pessoaService.listarPorId(pessoaId),HttpStatus.OK);
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> update(@PathVariable Long pessoaId, @RequestBody Pessoa pessoa){
        return new ResponseEntity<>(pessoaService.atualizar(pessoaId, pessoa),HttpStatus.OK);
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<String> delete(@PathVariable Long pessoaId){
        return new ResponseEntity<>(pessoaService.deletar(pessoaId),HttpStatus.OK);

    }
}
