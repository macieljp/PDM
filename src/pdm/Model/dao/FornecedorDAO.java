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
        Fornecedor temp;
        ArrayList<Fornecedor> lista = new ArrayList<>();

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("select * from fornecedor");
            // itera no ResultSet
            try ( // executa um select
                    ResultSet rs = stmt.executeQuery()) {
                // itera no ResultSet
                while (rs.next()) {

                    temp = new Fornecedor();
                    temp.setCod(String.valueOf(rs.getInt("cod")));
                    temp.setNome((rs.getString("nome")));
                    temp.setDescricao((rs.getString("descricao")));
                    temp.setTelefone((rs.getString("telefone")));
                    temp.setEmail((rs.getString("email")));
                    temp.setEndereco((rs.getString("endereco")));
                    temp.setCidade((rs.getString("cidade")));
                    temp.setUf((rs.getString("uf")));

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

    public boolean novo(Fornecedor fornecedor) {
        boolean a = false;
        String sql = "insert into fornecedor"
                + " ( nome, descricao,telefone,email,endereco,cidade,uf)"
                + " values ( ?,?,?,?,?,?,?)";

        try {
            // ps.setString(1, cli.getCod());
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                // ps.setString(1, cli.getCod());
                ps.setString(1, fornecedor.getNome());
                ps.setString(2, fornecedor.getDescricao());
                ps.setString(3, fornecedor.getTelefone());
                ps.setString(4, fornecedor.getEmail());
                ps.setString(5, fornecedor.getEndereco());
                ps.setString(6, fornecedor.getCidade());
                ps.setString(7, fornecedor.getUf());
                ps.execute();
                //con.close();
            }

        } catch (SQLException e) {
            System.out.println(a);
            System.out.println(e.getMessage());
            throw new RuntimeException();

        }

        return true;
    }

    public boolean editar(Fornecedor fornecedor) {

        String sql = "update cliente set nome=?, descricao=?, telefone=?, email=?, endereco=?,"
                + "cidade=?, uf=?, where cod=?";
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, fornecedor.getNome());
                ps.setString(2, fornecedor.getDescricao());
                ps.setString(3, fornecedor.getTelefone());
                ps.setString(4, fornecedor.getEmail());
                ps.setString(5, fornecedor.getEndereco());
                ps.setString(6, fornecedor.getCidade());
                ps.setString(7, fornecedor.getUf());

                ps.setInt(5, Integer.valueOf(fornecedor.getCod()));
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public int excluir(Fornecedor fornecedor) {
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
