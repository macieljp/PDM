/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Controller;

import java.sql.Connection;
import java.util.ArrayList;
import pdm.Model.Produto;
import pdm.Model.dao.ProdutoDAO;

/**
 *
 * @author JosielFaleiros
 */
public class ProdutoController {

    private final ProdutoDAO proDao;
    private Connection con;
    

    public ProdutoController() {
        this.proDao = new ProdutoDAO();
        
    }

    public ArrayList<Produto> getAllProdutos() {
        return proDao.todos();
    }

    public void salvarProduto(Produto produto) {
        
        
    

    
}

public void editarProduto(Produto produtos) {
        proDao.editar(produtos);
    }

    public void excluirProduto(Produto produtos) {
        proDao.excluir(produtos);
    }
}
