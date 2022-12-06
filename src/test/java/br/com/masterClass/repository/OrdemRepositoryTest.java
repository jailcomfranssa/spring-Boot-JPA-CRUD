package br.com.masterClass.repository;

import br.com.masterClass.entity.Endereco;
import br.com.masterClass.entity.Ordem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrdemRepositoryTest {

    @Autowired
    private OrdemRepository ordemRepository;

    @Test
    public  void saveOrderOperation(){
        //create Ordem objeto
        Ordem ordem = new Ordem();
        ordem.setNumRastreamentoPedido("100bc");
        ordem.setStatus("COMPLETADO");
        ordem.setPrecoTotal(new BigDecimal(2000));
        ordem.setQuantidadeTotal(5);

        //Create Endereço entrega
        Endereco entrega = new Endereco();
        entrega.setRua("um dois um");
        entrega.setCidade("JP");
        entrega.setEstado("PB");
        entrega.setPais("BR");
        entrega.setCodigoPostal("12587");

        ordem.setEnderecoCobranca(entrega);
        ordemRepository.save(ordem);
    }

    @Test
    public void fetchOrderOperation(){

        Ordem ordem = ordemRepository.findById(1L).get();
        System.out.println(ordem.toString());

    }

    @Test
    public void updateOrderOperation(){
        Ordem ordem1 = ordemRepository.findById(1L).get();
        System.out.println(ordem1.toString());

        ordem1.setStatus("DELIVERED_UP");
        ordem1.getEnderecoCobranca().setCodigoPostal("898989");

        ordemRepository.save(ordem1);

    }

    @Test
    public void deleteOrderOperation(){
        ordemRepository.deleteById(3L);

    }

}