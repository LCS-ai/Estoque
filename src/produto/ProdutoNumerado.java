package produto;

public class ProdutoNumerado extends Produto {

    private String numeracao;
    
    /**
     * Construtor da classe {@link ProdutoNumerado}.
     * Recebe o nome, codigo e a numeracao do produto e preenche na superclasse.
     * @param nome
     * @param codigo
     * @param numeracao
     */
    public ProdutoNumerado(String nome, String codigo, String numeracao) {
            super(nome, codigo);
            this.numeracao = numeracao;
    }
    
    /**
     * Construtor da classe {@link ProdutoNumerado}.
     * Recebe o nome, codigo, estoque e a numeracao do produto e preenche na superclasse.
     * @param nome
     * @param codigo
     * @param estoque
     * @param numeracao
     */
    public ProdutoNumerado(String nome, String codigo, int estoque, String numeracao) {
            super(nome, codigo, estoque);
            this.numeracao = numeracao;
    }
        
    /**
     * Construtor da classe {@link ProdutoComVariacoes}.
     * Recebe o nome, codigo, estoque, estoque minimo e a numeracao do produto e preenche na superclasse.
     * @param nome
     * @param codigo
     * @param estoque
     * @param estoqueMinimo
     * @param numeracao
     */
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