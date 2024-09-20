/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author ester
 */
public class Autores {
    
 private int id;
    private String nome;
    private String biografia;

    public Autores(int id, String nome, String biografia) {
        this.id = id;
        this.nome = nome;
        this.biografia = biografia;
    }

    public Autores(String nome, String biografia) {
        this.nome = nome;
        this.biografia = biografia;
    }

    
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

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
