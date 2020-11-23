package todososprodutos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import produto.Produto;

public class Lista {
    private Produto produto;
    private List<Produto> listaDeProdutos;
    private List<Produto> listaDeProdutosVendidos;
    private static Scanner scan;

    public Lista() {
        listaDeProdutos = new ArrayList<>();
        listaDeProdutosVendidos = new ArrayList<>();
    }

    public Lista(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return this.produto;
    }  

    public Produto buscaProduto(String buscaProduto) {
        
        produto = null;
        if (listaDeProdutos.size() > 0) {
            for (int i = 0; i < listaDeProdutos.size(); i++) {
                if (listaDeProdutos.get(i).getCodigo().equals(buscaProduto) || listaDeProdutos.get(i).getNome().equals(buscaProduto)) {
                    return produto = listaDeProdutos.get(i);
                }                
            }
        }
        return produto;        
    }

    public void adicionaProdutoNaLista() {
        String codigo = inString("Digite o código do produto: "); 
        

        for (int i = 0; i < listaDeProdutos.size(); i++) {
            if (!listaDeProdutos.get(i).getCodigo().equals(codigo)) {
                int opcao = inInt(
                        "\n=========| Digite a opção de cadastro |=========\n[1] Nome, Código, Quantidade, Aviso estoque baixo\n[2] Nome, Código, Quantidade\n[3] Nome, Código\n[4] Cancelar cadastro\n================================================");
                switch (opcao) {
                    case 1:
                        String nome = inString("Digite o nome do produto: ");
                        int quantidade1 = inInt("Digite a quantia em estoque: ");
                        int avisoEstoqueBaixo = inInt("Digite a quantia para aviso de estoque baixo: ");
                        listaDeProdutos.add(new Produto(nome, codigo, quantidade1, avisoEstoqueBaixo));
                        break;

                    case 2:
                        String nome1 = inString("Digite o nome do produto: ");
                        int quantidade2 = inInt("Digite a quantia em estoque: ");
                        listaDeProdutos.add(new Produto(nome1, codigo, quantidade2));
                        break;

                    case 3:
                        String nome2 = inString("Digite o nome do produto: ");
                        listaDeProdutos.add(new Produto(nome2, codigo));
                        break;

                    case 4:
                        System.out.println("Cadastro negado pelo usuário!");
                        break;

                    default:
                        break;
                }
            }

            else {
                System.out.println("Produto com o código: " + codigo + " já existe!");
            }
        }
    }

    public void excluirProduto(){
        String buscaProduto = inString("Digite o nome ou código do produto: ");
        listaDeProdutos.remove(buscaProduto(buscaProduto));

    }

    public static String inString(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static int inInt(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextInt();
    }

}
