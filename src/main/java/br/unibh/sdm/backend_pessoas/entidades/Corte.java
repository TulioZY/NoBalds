package br.unibh.sdm.backend_pessoas.entidades;

public enum Corte {
    Corte1("Cabelo"), 
    Barba1("Barba");

    private String descricao;

    Corte(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
