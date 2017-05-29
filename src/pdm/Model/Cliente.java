/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Model;

/**
 *
 * @author JosielFaleiros
 */
public class Cliente implements java.io.Serializable {
    //private static final long serialVersionUID = 1335421L;
    private String cod;
    private String nome;
    private String mediaCompra;
    private String telefone;
    private String email;
    private String endereco;
    private String cidade;
    private String uf;

    public Cliente() {
    }
    

    public Cliente(String cod, String nome, String mediaCompra, String telefone, String email, String endereco, String cidade, String uf) {
        this.cod = cod;
        this.nome = nome;
        this.mediaCompra = mediaCompra;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMediaCompra() {
        return mediaCompra;
    }

    public void setMediaCompra(String mediaCompra) {
        this.mediaCompra = mediaCompra;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String text) {
        this.cidade = text;
    }
    
}
