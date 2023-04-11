package br.unibh.sdm;

public class Pessoa {

    /**
     * Atributos de instância
    */

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    /**
     * Construtores
    */

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    


    /**
     * Métodos Gets e Sets
    */

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
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
        return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
    }

    /**
     * Métodos hashCode e equals
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
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
        return true;
    }

    

    
}
