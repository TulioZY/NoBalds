package br.unibh.sdm;

public class Cliente extends Pessoa {

    private String cpf;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String telefone, String cpf) {
        super(id, nome, email, telefone);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString()+" Cliente [cpf=" + cpf + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    
}
