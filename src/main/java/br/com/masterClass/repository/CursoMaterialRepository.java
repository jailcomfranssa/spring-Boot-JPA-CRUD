package br.com.masterClass.repository;

import br.com.masterClass.entity.CursoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoMaterialRepository extends JpaRepository<CursoMaterial, Long> {
}
