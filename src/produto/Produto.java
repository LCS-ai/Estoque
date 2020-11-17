package produto;

public class Produto {

    private String nome;
    private String codigo;
    private int quantidade;
    private int estoqueMinimo;

    public Produto(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = 0;
        this.estoqueMinimo = 0;
    }

    public Produto(String nome, String codigo, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.estoqueMinimo = 0;
    }

    public Produto(String nome, String codigo, int quantidade, int estoqueMinimo) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n Código: " + getCodigo() + "\nQuantidade: " + getQuantidade()
                + "\nAviso de estoque minimo configurado para :" + getEstoqueMinimo();
    }

}
