package br.com.masterClass.repository;

import br.com.masterClass.entity.Cpf;
import br.com.masterClass.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
