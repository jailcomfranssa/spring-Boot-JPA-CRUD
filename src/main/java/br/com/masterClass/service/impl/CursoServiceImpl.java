package br.com.masterClass.service.impl;

import br.com.masterClass.entity.Curso;
import br.com.masterClass.repository.CursoRepository;
import br.com.masterClass.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> listAll() {
        return cursoRepository.findAll();
    }
}
