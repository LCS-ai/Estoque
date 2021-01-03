package produto;

public class ProdutoNumerado extends Produto {

    private String numeracao;
    
    public ProdutoNumerado(String nome, String codigo, String numeracao) {
            super(nome, codigo);
            this.numeracao = numeracao;
    }
    
    public ProdutoNumerado(String nome, String codigo, int estoque, String numeracao) {
            super(nome, codigo, estoque);
            this.numeracao = numeracao;
    }
        
    public ProdutoNumerado(String nome, String codigo, int estoque, int estoqueMinimo, String numeracao) {
        super(nome, codigo, estoque, estoqueMinimo);
        this.numeracao = numeracao;
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
                "\n\tEstoque: " + this.getEstoque() + 
                "\n\tEstoque minimo: " + this.getEstoqueMinimo();
    }
}