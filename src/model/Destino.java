package model;

import java.sql.Date;

// Classe Date do pacote java.sql.
// Classe pública Destino
// Atributos privados
public class Destino {
    private int id;
    private int cidadeID;
    private Date dataViagem;

    // Construtor público
    // Atribui o valor do parâmetro ao atributo da classe.
    public Destino(int cidadeID, Date dataViagem) {
        this.cidadeID = cidadeID;
        this.dataViagem = dataViagem;
    }

    // Getters e Setters
    // Metodo público para retornar o valor do atributo e para definir o valor do atributo
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCidadeID() {
        return cidadeID;
    }
    public void setCidadeID(int cidadeID) {
        this.cidadeID = cidadeID;
    }
    public Date getDataViagem() {
        return dataViagem;
    }
    public void setDataViagem(Date dataViagem){
        this.dataViagem = dataViagem;
    }
}
