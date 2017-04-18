/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdm.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author JosielFaleiros
 */
public class FornecedorArquivo {
    File arquivo;
    private ObjectOutputStream escritor;
    private ObjectInputStream leitor;
                
    public FornecedorArquivo() {
        arquivo = new File("fornecedor.obj");
        escritor = CriaEscritorBinario(arquivo, true);
        leitor = CriaLeitorBinario(arquivo);
    }
    

    public ObjectOutputStream CriaEscritorBinario(
            File arquivo,
            boolean append) {
        ObjectOutputStream out = null;
        try {
            if (arquivo.exists()) {
                out = new ObjectOutputStream(
                        new FileOutputStream(arquivo, append)) {
                    @Override
                    protected void writeStreamHeader() {
                        // do not write a header
                    }
                };
            } else {
                out = new ObjectOutputStream(
                        new FileOutputStream(arquivo, append));
            }
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }

    public ObjectInputStream
            CriaLeitorBinario(File arquivo) {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis
                    = new FileInputStream(arquivo);
            ois = new ObjectInputStream(fis);
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo. " + erro);
        }
        return ois;
    }

    public void EscreveObjeto(
            ObjectOutputStream oos,
            Object obj,
            boolean flush) {
        try {
            oos.writeObject(obj);
            if (flush) {
                oos.flush();
            }
        } catch (IOException erro) {
            System.out.println("Erro na escrita. " + erro);
        }
    }

    public Object LeObjeto(ObjectInputStream ois) {
        Object objlido = null;
        try {
            objlido = ois.readObject();
        } catch (ClassNotFoundException erro) {
            System.out.println("Classe nao encontrada. "
                    + erro);
        } catch (java.io.EOFException erro) {
            System.out.println("Final de arquivo. "
                    + erro);
        } catch (IOException erro) {
            System.out.println("Erro na leitura do objeto. " + erro);
        } finally {
            return objlido;
        }
    }

    public void novoFornecedor(Fornecedor fornecedor) {
        System.out.println("novo fornecedor: "+fornecedor.getNome());
        EscreveObjeto(escritor, fornecedor, true);
    }

    public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
        arquivo.delete();
        arquivo = new File("fornecedor.obj");
        escritor = CriaEscritorBinario(arquivo, true);

        for (Fornecedor fornecedor : fornecedores) {
            EscreveObjeto(escritor, fornecedor, true);
        }
    }
    
    public ArrayList getAllFornecedores() {
        Fornecedor p = null;
        ArrayList result = new ArrayList();
        leitor = CriaLeitorBinario(arquivo);
        p = (Fornecedor) LeObjeto(leitor);
        if(p != null) {
            do {
                result.add(p);
                p = (Fornecedor) LeObjeto(leitor);
            } while (p!= null);
        }
        return result;
    }

}
