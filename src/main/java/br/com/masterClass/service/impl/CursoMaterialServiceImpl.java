package br.com.masterClass.service.impl;

import br.com.masterClass.entity.CursoMaterial;
import br.com.masterClass.repository.CursoMaterialRepository;
import br.com.masterClass.service.CursoMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoMaterialServiceImpl implements CursoMaterialService {

    private final CursoMaterialRepository cursoMaterialRepository;

    @Autowired
    public CursoMaterialServiceImpl(CursoMaterialRepository cursoMaterialRepository) {
        this.cursoMaterialRepository = cursoMaterialRepository;
    }

    @Override
    public CursoMaterial salvar(CursoMaterial cursoMaterial) {
        return cursoMaterialRepository.save(cursoMaterial);
    }

    @Override
    public List<CursoMaterial> listAll() {
        return cursoMaterialRepository.findAll();
    }


}
