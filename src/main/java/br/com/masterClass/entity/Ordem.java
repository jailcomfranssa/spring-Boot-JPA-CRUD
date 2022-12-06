package br.com.masterClass.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordemId;

    private String numRastreamentoPedido;

    private int quantidadeTotal;

    private BigDecimal precoTotal;

    private String status;

    @CreationTimestamp
    private Date dateCreated;

    @UpdateTimestamp
    private Date lastUpdated;

    //Unidirectional
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_cobranca_id", referencedColumnName = "enderecoId")
    private Endereco enderecoCobranca;

    public Long getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(Long ordemId) {
        this.ordemId = ordemId;
    }

    public String getNumRastreamentoPedido() {
        return numRastreamentoPedido;
    }

    public void setNumRastreamentoPedido(String numRastreamentoPedido) {
        this.numRastreamentoPedido = numRastreamentoPedido;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Endereco getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(Endereco enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "ordemId=" + ordemId +
                ", numRastreamentoPedido='" + numRastreamentoPedido + '\'' +
                ", quantidadeTotal=" + quantidadeTotal +
                ", precoTotal=" + precoTotal +
                ", status='" + status + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", enderecoCobranca=" + enderecoCobranca +
                '}';
    }
}
