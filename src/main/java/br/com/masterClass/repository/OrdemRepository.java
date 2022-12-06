package br.com.masterClass.repository;

import br.com.masterClass.entity.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {

    Ordem findByNumRastreamentoPedido(String numRastreamentoPedido);
}
