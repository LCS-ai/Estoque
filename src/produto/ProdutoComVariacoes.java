package produto;

import java.util.Arrays;

public class ProdutoComVariacoes extends Produto {

    private ProdutoNumerado[] variacoes = new ProdutoNumerado[5];
    private int tamanho = 0;
    private String  cor;

    /**
     * Construtor da classe {@link ProdutoComVariacoes}.
     * Recebe o nome e o codigo do produto e preenche na superclasse.
     * Atributo cor recebe valor 'indefinido'.
     * @param nome : String
     * @param codigo : String
     */
    public ProdutoComVariacoes(String nome, String codigo) {
        super(nome, codigo);
        this.cor = "indefinido";
    }
    
    /**
     * Construtor da classe {@link ProdutoComVariacoes}.
     * Recebe o nome, codigo e a cor do produto e preenche nos atributos de classe e superclasse.
     * Atributo cor recebe valor 'indefinido'.
     * @param nome : String
     * @param codigo : String
     * @param cor : String
     */
    public ProdutoComVariacoes(String nome, String codigo, String cor) {
        super(nome, codigo);
        this.cor = cor;
    }

    /**
     * Construtor da classe {@link ProdutoComVariacoes}.
     * Recebe o nome, codigo, estoque, estoque minimo e a cor do produto e preenche na superclasse.
     * @param nome : String
     * @param codigo : String
     * @param estoque : int
     * @param estoqueMinimo : int
     * @param cor : String
     */
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

    public void novaVariacao(String numeracao) {
        ProdutoNumerado variacao = new ProdutoNumerado(
                this.getNome(),
                this.getCodigo(),
                numeracao
            );
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

    /**
     * @return the variacoes
     */
    public ProdutoNumerado[] getVariacoes() {
        return variacoes;
    }

    @Override
    public String toString() {
        int i = 0;
        boolean condicao = i < variacoes.length;
        String numeracoes = "", estoque = "", estoqueMinimo = "";
        for (ProdutoNumerado produtoNumerado : variacoes) {
            if(produtoNumerado != null ) {
                numeracoes += (condicao) ? produtoNumerado.getNumeracao() 
                        +" | " : produtoNumerado.getNumeracao() + "\n";
                estoque += (condicao) ? " " + produtoNumerado.getEstoque() 
                        + retornaEspaco(produtoNumerado.getNumeracao().length()
                        -Integer.toString(produtoNumerado.getEstoque()).length()) +
                        "| " : produtoNumerado.getEstoque() + "\n";
                estoqueMinimo += (condicao) ? " " + produtoNumerado.getEstoqueMinimo() + 
                        retornaEspaco(produtoNumerado.getNumeracao().length()
                        -Integer.toString(produtoNumerado.getEstoqueMinimo()).length()) +
                        "| " : produtoNumerado.getEstoqueMinimo() + "\n";
                i++;
            }
        }
        return  "\tNome: " + this.getNome() + 
                "\n\tCódigo: " + this.getCodigo() + "\tCor: " + this.getCor() 
                + "\n\tNumeracoes     | "+ numeracoes+ "\n\tEstoque        | " + estoque + "\n\tEstoque Minimo | " + estoqueMinimo;
    }
}
