package br.com.masterClass.repository;

import br.com.masterClass.entity.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    public void printCurso(){
        List<Curso> curso = cursoRepository.findAll();
        System.out.println("Curso = "+ curso);
    }






































}