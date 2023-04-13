package br.unibh.sdm.backend_pessoas.entidades;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;


public class Cliente extends Pessoa {

    private String NomeBarbeiroPreferido;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String telefone, String cpf, String nomeBarbeiroPreferido) {
        super(id, nome, email, telefone, cpf);
        NomeBarbeiroPreferido = nomeBarbeiroPreferido;
    }

    @DynamoDBAttribute
    public String getNomeBarbeiroPreferido() {
        return NomeBarbeiroPreferido;
    }

    public void setNomeBarbeiroPreferido(String nomeBarbeiroPreferido) {
        NomeBarbeiroPreferido = nomeBarbeiroPreferido;
    }

    @Override
    public String toString() {
        return "Cliente [NomeBarbeiroPreferido=" + NomeBarbeiroPreferido + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((NomeBarbeiroPreferido == null) ? 0 : NomeBarbeiroPreferido.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (NomeBarbeiroPreferido == null) {
            if (other.NomeBarbeiroPreferido != null)
                return false;
        } else if (!NomeBarbeiroPreferido.equals(other.NomeBarbeiroPreferido))
            return false;
        return true;
    }


    
}
