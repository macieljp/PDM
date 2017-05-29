package pdm.Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
        return new ArrayList<>();
    }

    public boolean novo(Cliente cli) {
        boolean a = false;
        String sql = "insert into cliente"
                + " ( nome, mediaCompra,telefone,email,endereco,cidade,uf)"
                + " values ( ?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

           // ps.setString(1, cli.getCod());
            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getMediaCompra());
            ps.setString(3, cli.getTelefone());
            ps.setString(4, cli.getEmail());
            ps.setString(5, cli.getEndereco());
            ps.setString(6, cli.getCidade());
            ps.setString(7, cli.getUf());

           ps.execute();
            con.close();

        } catch (SQLException e) {
            System.out.println(a);
            System.out.println(e.getMessage());
            throw new RuntimeException();

        }

        return true;
    }

    public int editar(Cliente cli) {
        return 0;
    }

    public int excluir(Cliente cli) {
        return 0;
    }
}
