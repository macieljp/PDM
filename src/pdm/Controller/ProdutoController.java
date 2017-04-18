/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Controller;

import java.util.ArrayList;
import pdm.Model.Produto;
import pdm.Model.ProdutoArquivo;

/**
 *
 * @author JosielFaleiros
 */
public class ProdutoController {
    private ProdutoArquivo prArquivo;

    public ProdutoController() {
        this.prArquivo = new ProdutoArquivo();
    }
    
    public ArrayList getAllProdutos() {
        return prArquivo.getAllProdutos();
    }
    
    public void novoProduto(Produto produto) {
        prArquivo.novoProduto(produto);
    }
    
    public void setProdutos(ArrayList<Produto> produtos) {
        prArquivo.setProdutos(produtos);
    }
}
