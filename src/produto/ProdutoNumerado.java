package produto;

public class ProdutoNumerado extends Produto {

    private String numeracao, cor;
    
    public ProdutoNumerado(String nome, String codigo, String numeracao) {
            super(nome, codigo);
            this.numeracao = numeracao;
            this.cor = "indefinido";
    }
    
    public ProdutoNumerado(String nome, String codigo, int estoque, String numeracao) {
            super(nome, codigo, estoque);
            this.numeracao = numeracao;
            this.cor = "indefinido";
    }
        
    public ProdutoNumerado(String nome, String codigo, int estoque, int estoqueMinimo, String numeracao) {
        super(nome, codigo, estoque, estoqueMinimo);
        this.numeracao = numeracao;
        this.cor = "indefinido";
    }

    public ProdutoNumerado(String nome, String codigo, int estoque, int estoqueMinimo, String numeracao, String cor) {
        super(nome, codigo, estoque, estoqueMinimo);
        this.numeracao = numeracao;
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }

    @Override
    public String toString() {
        return  "\tNome: " + this.getNome() + 
                "\n\tCódigo: " + this.getCodigo() + 
                "\n\tNumeração: " + this.getNumeracao() +
                "\tCor: " + this.getCor() +
                "\n\tEstoque: " + this.getEstoque() + 
                "\n\tEstoque minimo: " + this.getEstoqueMinimo();
    }
}