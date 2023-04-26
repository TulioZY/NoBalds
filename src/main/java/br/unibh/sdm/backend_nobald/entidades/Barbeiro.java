package br.unibh.sdm.backend_nobald.entidades;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "barbeiro")
public class Barbeiro extends Pessoa {

    private String id;
    private String horario;

    public Barbeiro() {
    }

    public Barbeiro(String id, String nome, String email, String telefone, String cpf, String horario) {
        super(nome, email, telefone, cpf);
        this.id = id;
        this.horario = horario;
    }

    @DynamoDBHashKey
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

    @DynamoDBAttribute
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Barbeiro [horario=" + horario + "]" + super.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((horario == null) ? 0 : horario.hashCode());
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
        Barbeiro other = (Barbeiro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (horario == null) {
            if (other.horario != null)
                return false;
        } else if (!horario.equals(other.horario))
            return false;
        return true;
    }

    
}
