package pdm.Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pdm.Model.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author khigh
 */
public class ClienteDAO {

    Connection con;

    public ClienteDAO() {
        this.con = ConnectionManager.getConnection();
    }

    public Cliente findById(int id) {
        return null;
    }

    public ArrayList<Cliente> todos() {
        Cliente temp;
        ArrayList<Cliente> lista = new ArrayList<>();

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("select * from cliente");
            // itera no ResultSet
            try ( // executa um select
                    ResultSet rs = stmt.executeQuery()) {
                // itera no ResultSet
                while (rs.next()) {

                    //nome, mediaCompra,telefone,email,endereco,cidade,uf
                    temp = new Cliente();
                    temp.setCod(String.valueOf(rs.getInt("cod")));
                    temp.setNome((rs.getString("nome")));
                    temp.setMediaCompra((rs.getString("mediaCompra")));
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

    public boolean novo(Cliente cli) {
        boolean a = false;
        String sql = "insert into cliente"
                + " ( nome, mediaCompra,telefone,email,endereco,cidade,uf)"
                + " values ( ?,?,?,?,?,?,?)";

        try {
            // ps.setString(1, cli.getCod());
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                // ps.setString(1, cli.getCod());
                ps.setString(1, cli.getNome());
                ps.setString(2, cli.getMediaCompra());
                ps.setString(3, cli.getTelefone());
                ps.setString(4, cli.getEmail());
                ps.setString(5, cli.getEndereco());
                ps.setString(6, cli.getCidade());
                ps.setString(7, cli.getUf());
                ps.execute();
                // con.close();
            }

        } catch (SQLException e) {
            System.out.println(a);
            System.out.println(e.getMessage());
            throw new RuntimeException();

        }

        return true;
    }

    public boolean editar(Cliente cli) {

        //nome, mediaCompra,telefone,email,endereco,cidade,uf
        String sql = "update cliente set nome=?, mediaCompra=?, telefone=?, email=?, endereco=?,"
                + "cidade=?, uf=?, where cod=?";
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, cli.getNome());
                ps.setString(2, cli.getMediaCompra());
                ps.setString(3, cli.getTelefone());
                ps.setString(4, cli.getEmail());
                ps.setString(5, cli.getEndereco());
                ps.setString(6, cli.getCidade());
                ps.setString(7, cli.getUf());

                ps.setInt(5, Integer.valueOf(cli.getCod()));
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public int excluir(Cliente cli) {
        try {
            try (PreparedStatement ps = con.prepareStatement("delete from cliente where cod=?")) {
                ps.setInt(1, Integer.valueOf(cli.getCod()));
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
