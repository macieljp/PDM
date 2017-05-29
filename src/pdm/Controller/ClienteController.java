/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Controller;

import java.util.ArrayList;
import java.util.List;
import pdm.Model.Cliente;
import pdm.Model.dao.ClienteDAO;

/**
 *
 * @author JosielFaleiros
 */
public class ClienteController {
    private ClienteDAO clidao;

    public ClienteController() {
        this.clidao = new ClienteDAO();
    }
    
    public ArrayList<Cliente> getAllClientes() {
        return clidao.todos();
    }
    
    public void salvarNovoCliente(Cliente cliente) {
        clidao.novo(cliente);
    }

    public void editarCliente(Cliente cliente) {
        clidao.editar(cliente);
    }

    public void excluirCliente(Cliente cliente) {
        clidao.excluir(cliente);
    }
}
