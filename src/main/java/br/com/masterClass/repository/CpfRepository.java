package br.com.masterClass.repository;

import br.com.masterClass.entity.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpfRepository extends JpaRepository<Cpf, Long> {
}
