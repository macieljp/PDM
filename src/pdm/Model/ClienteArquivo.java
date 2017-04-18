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
public class ClienteArquivo {
    File arquivo;
    private ObjectOutputStream escritor;
    private ObjectInputStream leitor;
                
    public ClienteArquivo() {
        arquivo = new File("cliente.obj");
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

    public void novoCliente(Cliente cliente) {
        EscreveObjeto(escritor, cliente, true);
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        arquivo.delete();
        arquivo = new File("cliente.obj");
        escritor = CriaEscritorBinario(arquivo, true);

        for (Cliente cliente : clientes) {
            EscreveObjeto(escritor, cliente, true);
        }
    }
    
    public ArrayList getAllClientes() {
        Cliente c = null;
        ArrayList result = new ArrayList();
        leitor = CriaLeitorBinario(arquivo);

        c = (Cliente) LeObjeto(leitor);
        if(c != null) {
            do {
                result.add(c);
                c = (Cliente) LeObjeto(leitor);
            } while (c!= null);
        }
        return result;
    }


}
