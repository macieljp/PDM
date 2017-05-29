/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Controller;

import java.util.ArrayList;
import java.util.List;
import pdm.Model.Produto;
import pdm.Model.dao.ProdutoDAO;

/**
 *
 * @author JosielFaleiros
 */
public class ProdutoController {
    private ProdutoDAO prodao;

    public ProdutoController() {
        this.prodao = new ProdutoDAO();
    }
    
    public ArrayList<Produto> getAllProdutos() {
        return prodao.todos();
    }
    
    public void salvarProduto(Produto produto) {
        prodao.novo(produto);
    }
    
    public void editarProduto(Produto produtos) {
        prodao.editar(produtos);
    }

    public void excluirProduto(Produto produtos) {
        prodao.excluir(produtos);
    }
}
