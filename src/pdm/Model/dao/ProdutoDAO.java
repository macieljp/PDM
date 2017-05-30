/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pdm.Model.Produto;

/**
 *
 * @author khigh
 */
public class ProdutoDAO {

    Connection con;

    public ProdutoDAO() {
        this.con = ConnectionManager.getConnection();
    }

    public Produto findById(int id) {
        return null;
    }

    public ArrayList<Produto> todos() {
        Produto temp;
        ArrayList<Produto> lista = new ArrayList<>();

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("select * from produto");
            // itera no ResultSet
            try ( // executa um select
                    ResultSet rs = stmt.executeQuery()) {
                // itera no ResultSet
                while (rs.next()) {
                    //String cod, String nome, String descricao, String precoCompra, String precoVenda, String tamanho, String fornecedor

                    //nome, mediaCompra,telefone,email,endereco,cidade,uf
                    temp = new Produto();
                    temp.setCod(String.valueOf(rs.getInt("cod")));
                    temp.setNome((rs.getString("nome")));
                    temp.setDescricao((rs.getString("descricao")));
                    temp.setDescricao((rs.getString("precoCompra")));
                    temp.setPrecoVenda((rs.getString("precoVenda")));
                    temp.setTamanho((rs.getString("tamanho")));
                    temp.setFornecedor((rs.getString("fornecedor")));

                    lista.add(temp);
                }
            }
            stmt.close();
            //  con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean novo(Produto prod) {

        // this.con = ConnectionManager.getConnection();
        boolean a = false;
        String sql = "insert into fornecedor"
                + " ( nome, descricao,precoCompra,precoVenda,tamanho,fornecedor)"
                + " values ( ?,?,?,?,?,?)";

        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, prod.getNome());
                ps.setString(2, prod.getDescricao());
                ps.setString(3, prod.getPrecoCompra());
                ps.setString(4, prod.getPrecoVenda());
                ps.setString(5, prod.getTamanho());
                ps.setString(6, prod.getFornecedor());

                ps.execute();
            }

        } catch (SQLException e) {
            System.out.println(a);
            System.out.println(e.getMessage());
            throw new RuntimeException();

        }

        return true;
    }
    //nome, descricao,precoCompra,precoVenda,tamanho,fornecedor
//String cod, String nome, String descricao, String precoCompra, String precoVenda, String tamanho, String fornecedor

    public boolean editar(Produto produto) {
        String sql = "update produto set nome=?, descricao=?, precoCompra=?, precoVenda=?, tamanho=?,"
                + "fornecedor=?, where cod=?";
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, produto.getNome());
                ps.setString(2, produto.getDescricao());
                ps.setString(3, produto.getPrecoCompra());
                ps.setString(4, produto.getPrecoVenda());
                ps.setString(5, produto.getTamanho());
                ps.setString(6, produto.getFornecedor());

                ps.setInt(7, Integer.valueOf(produto.getCod()));
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public int excluir(Produto fornecedor) {
        try {
            try (PreparedStatement ps = con.prepareStatement("delete from fornecedor where cod=?")) {
                ps.setInt(1, Integer.valueOf(fornecedor.getCod()));
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;

    }
}
