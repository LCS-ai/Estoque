package produto;

import java.util.Arrays;

public class ProdutoComVariacoes extends Produto {

    private ProdutoNumerado[] variacoes = new ProdutoNumerado[5];
    private int tamanho = 0;
    private String  cor;

    public ProdutoComVariacoes(String nome, String codigo) {
        super(nome, codigo);
        this.cor = "indefinido";
    }

    public ProdutoComVariacoes(String nome, String codigo, int estoque) {
        super(nome, codigo, estoque);
        this.cor = "indefinido";
    }
    
    public ProdutoComVariacoes(String nome, String codigo, int estoque, int estoqueMinimo) {
        super(nome, codigo, estoque, estoqueMinimo);
        this.cor = "indefinido";
    }

    public ProdutoComVariacoes(String nome, String codigo, int estoque, int estoqueMinimo, String cor) {
        super(nome, codigo, estoque, estoqueMinimo);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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

    private String retornaEspaco(int tamanho) {
        String s = "";
        for (int i = 0; i < tamanho; i++) {
            s += " ";
        }
        return s;
    }

    @Override
    public String toString() {
        int i = 0;
        boolean condicao = i < variacoes.length;
        String numeracoes = "", estoque = "", estoqueMinimo = "";
        for (ProdutoNumerado produtoNumerado : variacoes) {
            numeracoes += (condicao) ? produtoNumerado.getNumeracao() +" | " : produtoNumerado.getNumeracao() + "\n";
            estoque += (condicao) ? " " + produtoNumerado.getEstoque() + retornaEspaco(produtoNumerado.getNumeracao().length()-Integer.toString(produtoNumerado.getEstoque()).length()) +"| " : produtoNumerado.getEstoque() + "\n";
            estoqueMinimo += (condicao) ? " " + produtoNumerado.getEstoqueMinimo() + retornaEspaco(produtoNumerado.getNumeracao().length()-Integer.toString(produtoNumerado.getEstoqueMinimo()).length()) +"| " : produtoNumerado.getEstoqueMinimo() + "\n";
            i++;
        }
        return  "\tNome: " + this.getNome() + 
                "\n\tCódigo: " + this.getCodigo() + "\tCor: " + this.getCor() 
                + "\n\tNumeracoes     | "+ numeracoes+ "\n\tEstoque        | " + estoque + "\n\tEstoque Minimo | " + estoqueMinimo;
    }
}
