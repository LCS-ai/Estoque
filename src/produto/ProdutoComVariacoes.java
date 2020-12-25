package produto;

import java.util.Arrays;

public class ProdutoComVariacoes extends Produto {

    private ProdutoNumerado[] variacoes = new ProdutoNumerado[5];
    private int tamanho = 0;

    public ProdutoComVariacoes(String nome, String codigo) {
        super(nome, codigo);
    }

    public ProdutoComVariacoes(String nome, String codigo, int estoque) {
        super(nome, codigo, estoque);
    }
    
    public ProdutoComVariacoes(String nome, String codigo, int estoque, int estoqueMinimo) {
        super(nome, codigo, estoque, estoqueMinimo);
    }

    public void novaVariacao(ProdutoNumerado variacao) {
        if(tamanho < variacoes.length) {
            variacoes[tamanho] = variacao;
            tamanho++;
        }
        else {
            variacoes = Arrays.copyOf(variacoes, variacoes.length*2);
            novaVariacao(variacao);
        }
    }
}
