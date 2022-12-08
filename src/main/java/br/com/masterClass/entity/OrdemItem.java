package br.com.masterClass.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class OrdemItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ordemItemId;

    private BigDecimal price;
    private int quantity;

    public Long getOrdemItemId() {
        return ordemItemId;
    }

    public void setOrdemItemId(Long ordemItemId) {
        this.ordemItemId = ordemItemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
