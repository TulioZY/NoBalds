package br.unibh.sdm.backend_nobald.entidades;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

public abstract class Pessoa {

    /**
     * Atributos de instância
    */

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    /**
     * Construtores
    */

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    


    /**
     * Métodos Gets e Sets
    */

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

    /**
     * Métodos toString
    */
    @Override
    public String toString() {
        return "[nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf="+cpf+"]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
     
}