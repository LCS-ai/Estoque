package produto;

public class Produto {

    private String nome;
    private String codigo;
    private int quantidade;
    private int avisoEstoqueBaixo;

    public Produto(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = 0;
        this.avisoEstoqueBaixo = 0;
    }


    public Produto(String nome, String codigo, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.avisoEstoqueBaixo = 0;
    }

    public Produto(String nome, String codigo, int quantidade, int avisoEstoqueBaixo) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.avisoEstoqueBaixo = avisoEstoqueBaixo;
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

    public int getAvisoEstoqueBaixo() {
        return this.avisoEstoqueBaixo;
    }

    public void setAvisoEstoqueBaixo(int avisoEstoqueBaixo) {
        this.avisoEstoqueBaixo = avisoEstoqueBaixo;
    }




    
}
