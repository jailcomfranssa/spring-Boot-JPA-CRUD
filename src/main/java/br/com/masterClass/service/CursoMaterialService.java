package br.com.masterClass.service;

import br.com.masterClass.entity.CursoMaterial;

import java.util.List;

public interface CursoMaterialService {
    public CursoMaterial salvar(CursoMaterial cursoMaterial);

    public List<CursoMaterial> listAll();
}
