package teste;

import java.util.*;

import produto.*;

public class TesteComOsProdutos {

    static List <Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        ProdutoComVariacoes pv, p1, alpargata;
        pv = new ProdutoComVariacoes("Nike", "NK001");
        p1 = new ProdutoComVariacoes("Nike", "NK0023", "Preto");
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "33/34"));
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "35/36"));
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "37/38"));
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "39/40"));
        pv.novaVariacao(new ProdutoNumerado(pv.getNome(), pv.getCodigo(), "41/42"));
        produtos.add(pv);
        produtos.add(new Produto("Adidas", "AD098"));
        produtos.add(new Produto("Topper", "TP0089", 34, 23));
        p1.novaVariacao("33/34");
        p1.novaVariacao("35/36");
        p1.novaVariacao("37/38");
        p1.novaVariacao("39/40");
        p1.novaVariacao("41/42");
        produtos.add(p1);
        mostraProdutos();
        alpargata = new ProdutoComVariacoes("Alpargata Flor", "AL300", "Rosa");
        alpargata.novaVariacao("33");
        alpargata.novaVariacao("34");
        alpargata.novaVariacao("35");
        alpargata.novaVariacao("36");
        alpargata.novaVariacao("37");
        alpargata.novaVariacao("38");
        alpargata.novaVariacao("39");
        alpargata.novaVariacao("40");
        mostraVariacoes(alpargata);
        produtos.add(alpargata);
        mostraProdutos();
    }

    public static void mostraProdutos() {
        for (Produto p : produtos) {
            if(p instanceof ProdutoComVariacoes) {
                ProdutoComVariacoes pv = (ProdutoComVariacoes) p;
            }
            System.out.println(p+"\n");
        }
    }

    public static void mostraVariacoes(ProdutoComVariacoes produto) {
        for (Produto p : produto.getVariacoes()) {
            System.out.println(p+"\n");
        }
    }
}
