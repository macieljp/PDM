/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import pdm.Model.Fornecedor;
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
        return new ArrayList<>();
    }

    public boolean novo(Produto prod) {
        boolean a = false;
        String sql = "insert into fornecedor"
                + " ( nome, descricao,precoCompra,precoVenda,tamanho,fornecedor)"
                + " values ( ?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, prod.getNome());
            ps.setString(2, prod.getDescricao());
            ps.setString(3, prod.getPrecoCompra());
            ps.setString(4, prod.getPrecoVenda());
            ps.setString(5, prod.getTamanho());
            ps.setString(6, prod.getFornecedor());

            ps.execute();
            con.close();

        } catch (SQLException e) {
            System.out.println(a);
            System.out.println(e.getMessage());
            throw new RuntimeException();

        }

        return true;
    }

    public int editar(Produto cli) {
        return 0;
    }

    public int excluir(Produto cli) {
        return 0;
    }
}
