package teste;

import produto.*;
import java.util.*;

public class TesteComOsProdutos {

    static List <Produto> produtos = new ArrayList<>();
    public static void main(String[] args) {
        
        ProdutoComVariacoes pv = new ProdutoComVariacoes("Nike", "NK001");
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "33/34"));
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "35/36"));
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "37/38"));
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "39/40"));
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "41/42"));
        produtos.add(pv);
        produtos.add(new Produto("Adidas", "AD098"));
        produtos.add(new Produto("Topper", "TP0089", 34, 23));
        mostraProdutos();
    }

    public static void mostraProdutos() {
        for (Produto p : produtos) {
            if(p instanceof ProdutoComVariacoes) {
                ProdutoComVariacoes pv = (ProdutoComVariacoes) p;
                System.out.println(pv+"\n");
            } else {
                System.out.println(p+"\n");
            }
        }
    }
}
