/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Controller;

import java.util.ArrayList;
import pdm.Model.Cliente;
import pdm.Model.ClienteArquivo;

/**
 *
 * @author JosielFaleiros
 */
public class ClienteController {
    private ClienteArquivo cliArquivo;

    public ClienteController() {
        this.cliArquivo = new ClienteArquivo();
    }
    
    public ArrayList getAllClientes() {
        return cliArquivo.getAllClientes();
    }
    
    public void salvarNovoCliente(Cliente cliente) {
        cliArquivo.novoCliente(cliente);
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        cliArquivo.setClientes(clientes);
    }
}
