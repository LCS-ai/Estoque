package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparadores.ComparadorDeEstoque;
import produto.*;

public class Lista {

    private List<Produto> listaDeProdutos;
    private List<Produto> listaDeProdutosVendidos;

    public Lista() {
        listaDeProdutos = new ArrayList<>();
        listaDeProdutosVendidos = new ArrayList<>();
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    /*
     * TODO Cuidado neste método, se retornar o estoque mais alto, seleciono último
     * index com listaDeProdutos.get(listaDeProdutos.size( )-1)
     */
    public Produto produtoComEstoqueMaisBaixo() {
        if (!listaDeProdutos.isEmpty()) {
            ComparadorDeEstoque ordemEstoqueMaisBaixo = new ComparadorDeEstoque();
            Collections.sort(listaDeProdutos, ordemEstoqueMaisBaixo);
            return listaDeProdutos.get(0);
        } else {
            return null;
        }

    }

    public int tamanhoDalistaDeProdutos() {
        return listaDeProdutos.size();
    }

    public int tamanhoDalistaDeProdutosVendidos() {
        return listaDeProdutosVendidos.size();
    }

    public void adicionaProduto(Produto p) {
        this.listaDeProdutos.add(p);
    }

    public Produto retornaProduto(int i) {
        return listaDeProdutos.get(i);
    }

    public Produto retornaProdutoVendido(int i) {
        return listaDeProdutosVendidos.get(i);
    }

    /**
     * Metodo que recebe uma String de pesquisa e procura na lista de produtos. Ao
     * encontrar retorna o indice do produto na tabela. Caso nao encontre, retorna
     * -1.
     * 
     * @param pesquisa : String
     * @return indice : int
     */
    public int pesquisaProduto(String pesquisa) {
        int indice = -1;
        pesquisa = pesquisa.toLowerCase();
        for (Produto p : listaDeProdutos) {
            if (p.getNome().toLowerCase().contains(pesquisa) || p.getCodigo().toLowerCase().contains(pesquisa)) {
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

    public boolean verificaExistenciaDoProduto(String palavra) {
        if (!listaDeProdutos.isEmpty()) {
            for (int i = 0; i < listaDeProdutos.size(); i++) {
                if (listaDeProdutos.get(i).getCodigo().equals(palavra)
                        || listaDeProdutos.get(i).getNome().equals(palavra))
                    return true;
            }
        }
        return false;
    }

    public boolean verificaExistenciaDoProdutoDuasPalavras(String nome, String codigo) {
        if (!listaDeProdutos.isEmpty()) {
            for (int i = 0; i < listaDeProdutos.size(); i++) {
                if (listaDeProdutos.get(i).getCodigo().equals(codigo) && listaDeProdutos.get(i).getNome().equals(nome))
                    return true;
            }
        }
        return false;
    }

}
