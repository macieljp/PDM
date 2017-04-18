/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Controller;

import java.util.ArrayList;
import pdm.Model.Fornecedor;
import pdm.Model.FornecedorArquivo;

/**
 *
 * @author JosielFaleiros
 */
public class FornecedorController {
    private FornecedorArquivo frArquivo;

    public FornecedorController() {
        this.frArquivo = new FornecedorArquivo();
    }
    
    public ArrayList getAllFornecedores() {
        return frArquivo.getAllFornecedores();
    }
    
    public void novoFornecedor(Fornecedor fornecedor) {
        frArquivo.novoFornecedor(fornecedor);
    }

    public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
        frArquivo.setFornecedores(fornecedores);
    }
}
