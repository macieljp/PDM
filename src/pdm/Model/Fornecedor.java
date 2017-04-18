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
public class Fornecedor implements java.io.Serializable {
    private static final long serialVersionUID = 1335423L;
    private String cod;
    private String nome;
    private String descricao;
    private String telefone;
    private String email;
    private String endereco;
    private String cidade;
    private String uf;

    public Fornecedor() {
    }
    

    public Fornecedor(String cod, String nome, String descricao, String telefone, String email, String endereco, String cidade, String uf) {
        this.cod = cod;
        this.nome = nome;
        this.descricao = descricao;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String text) {
        this.cod = text;
    }
    
}
