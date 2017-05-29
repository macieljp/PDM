/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Controller;

import java.util.ArrayList;
import java.util.List;
import pdm.Model.Fornecedor;
import pdm.Model.dao.FornecedorDAO;

/**
 *
 * @author JosielFaleiros
 */
public class FornecedorController {
    private FornecedorDAO fordao;

    public FornecedorController() {
        this.fordao = new FornecedorDAO();
    }
    
    public ArrayList<Fornecedor> getAllFornecedores() {
        return fordao.todos();
    }
    
    public void salvarFornecedor(Fornecedor fornecedor) {
        fordao.novo(fornecedor);
    }

    public void editarFornecedor(Fornecedor fornecedore) {
        fordao.editar(fornecedore);
    }

    public void excluirFornecedor(Fornecedor fornecedore) {
        fordao.excluir(fornecedore);
    }
}
