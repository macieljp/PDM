package pdm.Model.dao;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
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
    
    public ClienteDAO () {
        this.con = ConnectionManager.getConnection();
    }
    
    public Cliente findById(int id) {
        return null;
    }
    
    public ArrayList<Cliente> todos() {
        return new ArrayList<>();
    }
    
    public int novo(Cliente cli) {
        return 0;
    }
    
    public int editar(Cliente cli) {
        return 0;
    }
    
    public int excluir(Cliente cli) {
        return 0;
    }
}
