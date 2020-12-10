package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import produto.Produto;


public class ManipulaArquivo {

    private ArrayList <Produto> lista = new ArrayList<>();

    private File f = new File("./data/productsData.txt");

    private String chave = ",";

    public List<Produto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Produto> lista) {
        this.lista = lista;
    }

    public void criaArquivo() throws IOException {
        if (!f.exists()) {
            f.createNewFile();
        }
    }

    public void leArquivo() throws IOException {
        FileReader reader = new FileReader(f);
        BufferedReader bReader = new BufferedReader(reader);
        boolean b = true;
        String txt = "";
        while(b) {
            txt = bReader.readLine();
            if(txt != null) {
                Produto p = formataProdutoDoArquivo(txt);
                System.out.println(p);
                lista.add(p);
            } else
                b = false;
        }
        bReader.close();
    }

    public void escreveArquivo() throws IOException {
        FileWriter writer = new FileWriter(f);
        BufferedWriter bWriter = new BufferedWriter(writer);
        for (Produto p : lista) {
            String linha = p.getNome()+chave+
                    p.getCodigo()+chave+
                    Integer.toString(p.getEstoque())+chave+
                    Integer.toString(p.getEstoqueMinimo());
            bWriter.append(linha+"\n");
        }
        bWriter.close();
    }


    public Produto formataProdutoDoArquivo(String linha) {
        
        String [] dados = linha.split(chave);

        String nome = "", codigo = "";
        int estoque = 0, estoqueMinimo = 0;
        // dados[0].matches("\\w") && 
        if(dados[0]!= null) {
            nome = dados[0];
        }
        // dados[1].matches("[A-Za-z0-9]") &&
        if(dados[1]!= null) {
            codigo = dados[1];
        }
        // dados[2].matches("\\d") && 
        if(dados[2]!= null) {
            estoque = Integer.parseInt(dados[2]);
        }
        // dados[3].matches("\\d") && 
        if(dados[3]!= null) {
            estoqueMinimo = Integer.parseInt(dados[3]);
        }
        return new Produto(nome, codigo, estoque, estoqueMinimo);
    }
}
