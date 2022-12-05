package br.com.masterClass.controller;

import br.com.masterClass.entity.Curso;
import br.com.masterClass.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;
    private final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping()
    public ResponseEntity<List<Curso>> listarTodos(){
        LOGGER.info("Listando Todos os Curso");
        return new ResponseEntity<>(cursoService.listAll(), HttpStatus.OK);
    }
}
