package br.com.masterClass.controller;

import br.com.masterClass.entity.Student;
import br.com.masterClass.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> criarEstudante(@RequestBody Student student){

        LOGGER.info("Student Salvo Sucesso..");
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> buscarTodos(){
        LOGGER.info("Listando Todos Estudantes...");
        return new ResponseEntity<>(studentService.listAll(),HttpStatus.OK);
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<Student>> buscarPorNome(@PathVariable String firstName){
        LOGGER.info("Buscando Estudante Pelo Nome..");
        return new ResponseEntity<>(studentService.listarPorNome(firstName),HttpStatus.OK);

    }

    @GetMapping("/containing/nome/{nome}")
    public ResponseEntity<List<Student>> nomeContem(@PathVariable String nome){
        LOGGER.info("Buscar por contem no nome...");
        return new ResponseEntity<>(studentService.containingNome(nome),HttpStatus.OK);

    }

    @GetMapping("/guardian/{nome}")
    public ResponseEntity<List<Student>> buscarPorGuardianName(@PathVariable String nome){
        LOGGER.info("Buscando por GuardianName...");
        return new ResponseEntity<>(studentService.guardianName(nome), HttpStatus.OK);

    }

}
