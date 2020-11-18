package todososprodutos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import produto.Produto;

public class Lista {
    private Produto produto; // não entendi a função disso
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

    public boolean verificaExistenciaMesmoCodigo(String codigo) {
        if (!listaDeProdutos.isEmpty()) {
            for (int i = 0; i < listaDeProdutos.size(); i++) {
                if (listaDeProdutos.get(i).getCodigo().equals(codigo))
                    return true;    
            }
        }
        return false;
    }

    public void adicionaProdutoNaLista() {
        String nome;
        int quantidade;
        String codigo = inString("Digite o código do produto: ");
        if (verificaExistenciaMesmoCodigo(codigo)) {
                System.out.println("Produto com o código: " + codigo + " já existe!");
        } else {
            int opcao = inInt(
                    "\n=========| Digite a opção de cadastro |=========\n\n"+
                    "[1] Nome, Código, Quantidade, Estoque mínimo\n"+
                    "[2] Nome, Código, Quantidade\n"+
                    "[3] Nome, Código\n"+
                    "[4] Cancelar cadastro\n"+
                    "\n================================================");
            switch (opcao) {
                case 1:
                    nome = inString("Digite o nome do produto: ");
                    quantidade = inInt("Digite a quantia em estoque: ");
                    int estoqueMinimo = inInt("Digite o estoque mínimo para o produto: ");
                    listaDeProdutos.add(new Produto(nome, codigo, quantidade, estoqueMinimo));
                    break;

                case 2:
                    nome = inString("Digite o nome do produto: ");
                    quantidade = inInt("Digite a quantia em estoque: ");
                    listaDeProdutos.add(new Produto(nome, codigo, quantidade));
                    break;

                case 3:
                    nome = inString("Digite o nome do produto: ");
                    listaDeProdutos.add(new Produto(nome, codigo));
                    break;

                case 4:
                    System.out.println("Cadastro negado pelo usuário!");
                    break;

                default:
                    break;
            }
        }
    }

    public void mostraEstoque() {
        int posicao = 1;
        if (listaDeProdutos.isEmpty())
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else { 
            System.out.println("\n\n\t=========| Estoque de produtos: |=========\n\n");
            for (Produto p : listaDeProdutos) {
                System.out.println(posicao +"\n"+p+"\n");
            }
            System.out.println("\t\t\t\t\tTotal de produtos em estoque: "+listaDeProdutos.size());
            System.out.println("\n============================================");
        }
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
