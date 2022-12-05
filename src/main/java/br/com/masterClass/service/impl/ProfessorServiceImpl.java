package br.com.masterClass.service.impl;

import br.com.masterClass.repository.ProfessorRepository;
import br.com.masterClass.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


}
