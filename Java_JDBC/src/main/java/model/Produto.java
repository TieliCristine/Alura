package model;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;

    /*-----------------------------------------CONSTRUCTOR----------------------------------------------*/

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    public Produto(Integer id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    /*-------------------------------------GETTERS AND SETTERS-----------------------------------------*/

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*--------------------------------------------TOSTRING---------------------------------------------*/

    @Override
    public String toString() {
        return String.format("O produto e: %d, %s, %s",
                this.id, this.nome, this.descricao);
    }
}

