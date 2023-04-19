package br.unibh.sdm.backend_pessoas.entidades;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.text.DecimalFormat;

@DynamoDBTable(tableName = "servico")
public class Servico {

    private String barbeiroId;
    private String pessoaId;
    private String descricao;
    private DecimalFormat preco;

    public Servico() {
    }
    @DynamoDBAttribute
    public String getBarbeiroId() {
        return barbeiroId;
    }

    public void setBarbeiroId(String barbeiroId) {
        this.barbeiroId = barbeiroId;
    }

    @DynamoDBAttribute
    public String getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(String pessoaId) {
        this.pessoaId = pessoaId;
    }

    @DynamoDBAttribute
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @DynamoDBAttribute
    public DecimalFormat getPreco() {
        return preco;
    }

    public void setPreco(DecimalFormat preco) {
        this.preco = preco;
    }

    

    @Override
    public String toString() {
        return "Servico [barbeiroId=" + barbeiroId + ", pessoaId=" + pessoaId + ", descricao=" + descricao + ", preco="
                + preco + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((barbeiroId == null) ? 0 : barbeiroId.hashCode());
        result = prime * result + ((pessoaId == null) ? 0 : pessoaId.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((preco == null) ? 0 : preco.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Servico other = (Servico) obj;
        if (barbeiroId == null) {
            if (other.barbeiroId != null)
                return false;
        } else if (!barbeiroId.equals(other.barbeiroId))
            return false;
        if (pessoaId == null) {
            if (other.pessoaId != null)
                return false;
        } else if (!pessoaId.equals(other.pessoaId))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (preco == null) {
            if (other.preco != null)
                return false;
        } else if (!preco.equals(other.preco))
            return false;
        return true;
    }

    public Servico(String barbeiroId, String pessoaId, String descricao, DecimalFormat preco) {
        this.barbeiroId = barbeiroId;
        this.pessoaId = pessoaId;
        this.descricao = descricao;
        this.preco = preco;
    }

    

    
}