package br.unibh.sdm.backend_nobald.entidades;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "cliente")
public class Cliente {
    
    @DynamoDBHashKey
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String NomeBarbeiroPreferido;

    public Cliente() {
    }

    public Cliente(String id, String nome, String email, String telefone, String cpf, String nomeBarbeiroPreferido) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.NomeBarbeiroPreferido = nomeBarbeiroPreferido;
    }

    @DynamoDBHashKey
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

    @DynamoDBAttribute
    public String getNomeBarbeiroPreferido() {
        return NomeBarbeiroPreferido;
    }

    public void setNomeBarbeiroPreferido(String nomeBarbeiroPreferido) {
        NomeBarbeiroPreferido = nomeBarbeiroPreferido;
    }

    @DynamoDBAttribute
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    @DynamoDBAttribute
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@DynamoDBAttribute
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

	@DynamoDBAttribute
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (NomeBarbeiroPreferido == null) {
            if (other.NomeBarbeiroPreferido != null)
                return false;
        } else if (!NomeBarbeiroPreferido.equals(other.NomeBarbeiroPreferido))
            return false;
        return true;
    }

    
    
}