package br.com.masterClass.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "cpfId")
public class Cpf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cpfId;

    private String numDocumento;
    private String dataEmissao;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cpf", fetch = FetchType.LAZY)
    private Pessoa pessoa;

    public Long getCpfId() {
        return cpfId;
    }

    public void setCpfId(Long cpfId) {
        this.cpfId = cpfId;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Cpf{" +
                "cpfId=" + cpfId +
                ", numDocumento='" + numDocumento + '\'' +
                ", dataEmissao='" + dataEmissao + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
