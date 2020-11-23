package util;

import java.util.ArrayList;
import java.util.List;

import produto.*;

public class Lista {
    private Produto produto; // não entendi a função disso
    private List<Produto> listaDeProdutos;
    private List<Produto> listaDeProdutosVendidos;


    public Lista() {
        listaDeProdutos = new ArrayList<>();
        listaDeProdutosVendidos = new ArrayList<>();
    }

    // public Lista(Produto produto) {
    //     this.produto = produto;
    // }

    // public Produto getProduto() {
    //     return this.produto;
    // }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    /**
     * Metodo que recebe uma String de pesquisa e procura na lista de produtos.
     * Ao encontrar retorna o indice do produto na tabela.
     * Caso nao encontre, retorna -1.
     * @param pesquisa : String
     * @return : int
     */
    public int pesquisaProduto(String pesquisa) {
        int indice = -1;
        pesquisa = pesquisa.toLowerCase();
        for (Produto p : listaDeProdutos) {
            if(p.getNome().toLowerCase().contains(pesquisa) || 
                    p.getCodigo().toLowerCase().contains(pesquisa)) {
                indice = listaDeProdutos.indexOf(p);
                break;
            }
        }
        return indice;
    }

    public boolean verificaExistenciaMesmoCodigo(String codigo) {
        if (!listaDeProdutos.isEmpty()) {
            for (int i = 0; i < listaDeProdutos.size(); i++) {
                if (listaDeProdutos.get(i).getCodigo().equals(codigo))
                    return true;    
            }
        }
        return false;
    }

     

}
