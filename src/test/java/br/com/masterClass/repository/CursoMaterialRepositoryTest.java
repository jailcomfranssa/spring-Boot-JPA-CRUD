package br.com.masterClass.repository;

import br.com.masterClass.entity.Curso;
import br.com.masterClass.entity.CursoMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CursoMaterialRepositoryTest {

    @Autowired
    private CursoMaterialRepository repository;

    @Test
    public void SaveCorsoMaterial(){

        Curso curso = Curso.builder()
                .title("DSA")
                .credit(6)
                .build();

        CursoMaterial cursoMaterial = CursoMaterial.builder()
                .url("www.google.com")
                .curso(curso)
                .build();
        repository.save(cursoMaterial);
    }



}



































