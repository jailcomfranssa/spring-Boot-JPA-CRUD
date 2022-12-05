package br.com.masterClass.repository;

import br.com.masterClass.entity.Curso;
import br.com.masterClass.entity.Professor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfessorRepositoryTest {

    @Autowired
    private ProfessorRepository professorRepository;

    @Test
    public void saveProfessor(){

        Curso curso = Curso.builder()
                .title("BDA")
                .credit(5)
                .build();

        Curso cursoJava = Curso.builder()
                .title("Java")
                .credit(6)
                .build();

        Curso cursoCSS = Curso.builder()
                .title("Css")
                .credit(8)
                .build();

        Professor professor = Professor.builder()
                .firstName("Pedro")
                .lastName("Caninha")
                .cursos(List.of(curso,cursoJava,cursoCSS))
                .build();
        professorRepository.save(professor);
    }

}