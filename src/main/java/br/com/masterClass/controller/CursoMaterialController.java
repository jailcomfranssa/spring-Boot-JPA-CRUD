package br.com.masterClass.controller;

import br.com.masterClass.entity.CursoMaterial;
import br.com.masterClass.service.CursoMaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursoMaterial")
public class CursoMaterialController {

    private final CursoMaterialService cursoMaterialService;
    private final Logger LOGGER = LoggerFactory.getLogger(CursoMaterialController.class);

    public CursoMaterialController(CursoMaterialService cursoMaterialService) {
        this.cursoMaterialService = cursoMaterialService;
    }

    @PostMapping()
    public ResponseEntity<CursoMaterial> criar(@RequestBody CursoMaterial cursoMaterial){
        LOGGER.info("Criando Curso Material...");
        return new ResponseEntity<>(cursoMaterialService.salvar(cursoMaterial), HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<List<CursoMaterial>> listarTodos(){
        LOGGER.info("Listando Todos os Curso Material");
        return new ResponseEntity<>(cursoMaterialService.listAll(),HttpStatus.OK);

    }
}
