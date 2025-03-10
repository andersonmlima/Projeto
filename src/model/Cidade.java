package model;

// Classe pública Cidade
// Atributos privados
public class Cidade {
    private int id;
    private String nome;
    private String pais;

    // Construtor público
    // Atribui o valor do parâmetro ao atributo da classe
    public Cidade(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }

    // Getters e Setters
    // Metodo público para retornar o valor do atributo e para definir o valor do atributo
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
}
