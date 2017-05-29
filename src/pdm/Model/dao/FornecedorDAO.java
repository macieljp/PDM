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

/**
 *
 * @author khigh
 */
public class FornecedorDAO {

    Connection con;

    public FornecedorDAO() {
        this.con = ConnectionManager.getConnection();
    }

    public Fornecedor findById(int id) {
        return null;
    }

    public ArrayList<Fornecedor> todos() {
        return new ArrayList<>();
    }

    public boolean novo(Fornecedor fornecedor) {
        boolean a = false;
        String sql = "insert into fornecedor"
                + " ( nome, descricao,telefone,email,endereco,cidade,uf)"
                + " values ( ?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            // ps.setString(1, cli.getCod());
            ps.setString(1, fornecedor.getNome());
            ps.setString(2, fornecedor.getDescricao());
            ps.setString(3, fornecedor.getTelefone());
            ps.setString(4, fornecedor.getEmail());
            ps.setString(5, fornecedor.getEndereco());
            ps.setString(6, fornecedor.getCidade());
            ps.setString(7, fornecedor.getUf());

            ps.execute();
            con.close();

        } catch (SQLException e) {
            System.out.println(a);
            System.out.println(e.getMessage());
            throw new RuntimeException();

        }

        return true;
    }

    public int editar(Fornecedor cli) {
        return 0;
    }

    public int excluir(Fornecedor cli) {
        return 0;
    }
}
