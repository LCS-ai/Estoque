package produto;

public class Produto{

    protected String nome;
    protected String codigo;
    protected int estoque;
    protected int estoqueMinimo;

    public Produto(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = 0;
        this.estoqueMinimo = 0;
    }

    public Produto(String nome, String codigo, int estoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = estoque;
        this.estoqueMinimo = 0;
    }

    public Produto(String nome, String codigo, int estoque, int estoqueMinimo) {
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = estoque;
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public String toString() {
        return  "\tNome: " + this.getNome() + 
                "\n\tCódigo: " + this.getCodigo() + 
                "\n\tEstoque: " + this.getEstoque() + 
                "\n\tEstoque minimo: " + this.getEstoqueMinimo();
    }

}
