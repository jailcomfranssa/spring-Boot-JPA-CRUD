package br.com.masterClass.repository;

import br.com.masterClass.entity.Ordem;
import br.com.masterClass.entity.OrdemItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class OneToManyUnidirectionalMappingTest {

    @Autowired
    private OrdemRepository ordemRepository;

    @Test
    void testSaveOrder(){

        Ordem ordem = new Ordem();

        OrdemItem ordemItem1 = new OrdemItem();
        OrdemItem ordemItem2 = new OrdemItem();

        ordemItem1.setPrice(new BigDecimal(100));
        ordemItem1.setQuantity(2);

        ordemItem2.setPrice(new BigDecimal(100));
        ordemItem2.setQuantity(1);

        ordem.setNumRastreamentoPedido("100bc");
        ordem.setStatus("COMPLETADO");
        ordem.setPrecoTotal(new BigDecimal(2000));
        ordem.setQuantidadeTotal(5);

        ordem.add(ordemItem1);
        ordem.add(ordemItem2);

        ordemRepository.save(ordem);
    }

    @Test
    void testGetAllOrders(){

        List<Ordem> ordems = ordemRepository.findAll();
//
//        ordems.forEach((o)->{
//            System.out.println("Ordem Id :: " + o.getOrdemId());
//            o.getOrdemItems().forEach((orderItem->{
//                System.out.println("ordemItem :: " + orderItem.getOrdemItemId());
//            }));
//        });

        ordems.forEach((o)->{
            System.out.println("Ordem Id :: " + o);
            o.getOrdemItems().forEach((orderItem->{
                System.out.println("ordemItem :: " + orderItem);
            }));
        });

    }
}
