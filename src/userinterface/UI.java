package userinterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import produto.*;
import util.*;

public class UI {
    private Lista lista;
    private static Scanner scan;
    private List<Produto> listaResultadoDaPesquisa;
    private int numeroDeResultados;

    public UI() {
        lista = new Lista();
        listaResultadoDaPesquisa = new ArrayList<>();
    }

    public void menu() throws IOException, InterruptedException {
        boolean start = true;
        do {
            LimpaConsole.main(new String [10]);
            int opcao = inInt(
                "\n=========| Digite a opção desejada |=========\n\n"+
                "[1] Visualizar estoque\n"+
                "[2] Pesquisar produto\n"+
                "[3] Adicionar produto\n"+
                "[4] Editar produto\n"+
                "[5] Apagar produto\n"+
                "[6] Sair\n"+
                "\n=============================================");
            switch (opcao) {
                case 1:
                    mostraEstoque();
                    scan.hasNext();
                    break;
                case 2:
                    mostraProdutosParaAPesquisa();
                    scan.hasNext();
                    break;
                case 3:
                    adicionaProdutoNaLista();
                    scan.hasNext();
                    break;
                case 4:
                    editarProduto();
                    scan.next();
                    break;
                    case 5:
                    excluirProduto();
                    scan.next();
                    break;
                    case 6:
                    start = false;
                    break;
                default:
                    break;
                }
        } while(start);
    }

    /*
     * TODO Modificar a estrutura do metodo para cadastrar o produto aí mostrar o
     * aviso somente se já houver o produto com o mesmo código.
     */
    private void adicionaProdutoNaLista() {
        String nome;
        int quantidade;
        String codigo = inString("Digite o código do produto: ");
        if (lista.verificaExistenciaMesmoCodigo(codigo))
                System.out.println("\n\n\tProduto com o código " + codigo + " já existe!");
        else {
            int opcao = inInt(
                    "\n=========| Digite a opção de cadastro |=========\n\n"+
                    "[1] Nome, Código, Estoque, Estoque mínimo\n"+
                    "[2] Nome, Código, Estoque\n"+
                    "[3] Nome, Código\n"+
                    "[4] Cancelar cadastro\n"+
                    "\n================================================");
            switch (opcao) {
                case 1:
                    nome = inString("Digite o nome do produto: ");
                    quantidade = inInt("Digite a quantia em estoque: ");
                    int estoqueMinimo = inInt("Digite o estoque mínimo para o produto: ");
                    lista.getListaDeProdutos().add(new Produto(nome, codigo, quantidade, estoqueMinimo));
                    break;
                    
                case 2:
                    nome = inString("Digite o nome do produto: ");
                    quantidade = inInt("Digite a quantia em estoque: ");
                    lista.getListaDeProdutos().add(new Produto(nome, codigo, quantidade));
                    break;
                    
                case 3:
                    nome = inString("Digite o nome do produto: ");
                    lista.getListaDeProdutos().add(new Produto(nome, codigo));
                    break;
                
                case 4:
                    System.out.println("Cadastro negado pelo usuário!");
                    break;
                
                default:
                    break;
            }
        }
    }
    
    private void editarProduto() {
        if (!verificaListaVazia(lista.getListaDeProdutos())) {
            menuDeEdicao();
        }
    }

    private void menuDeEdicao() {
        String pesquisa = inString("Digite o nome ou código do produto que deseja editar: ");
        mostraProdutosParaAPesquisa(pesquisa);
        if(numeroDeResultados != 1) {
            System.out.println("\n\n\tExiste mais de um produto com '"+pesquisa+"'\n"+
                "\tPor favor, busque pelo código do produto!");
                menuDeEdicao();
        }
        
        int indice = lista.pesquisaProduto(pesquisa);
        Produto produtoAntigo;
        if(indice < 0)
            System.out.println("\n\n\tNão foram encontrados resultados para '"+pesquisa+"'!");
        else {
            produtoAntigo = lista.getListaDeProdutos().get(indice);
            System.out.println("\n"+produtoAntigo);
            boolean mostrarTela = true;
            do {
                int opcao = inInt(
                    "\n==========| Digite a opção de edicão |==========\n\n"+
                    "[1] Nome\n"+
                    "[2] Código\n"+
                    "[3] Estoque\n"+
                    "[4] Estoque mínimo\n"+
                    "[5] Voltar\n"+
                    "\n================================================");
                switch (opcao) {
                    case 1:
                        String nome = inString("Digite o novo nome para o produto: ");
                        lista.getListaDeProdutos().get(indice).setNome(nome);
                        break;
                    case 2:
                        String codigo = inString("Digite o novo codigo para o produto: ");
                        lista.getListaDeProdutos().get(indice).setCodigo(codigo);
                        break;
                    case 3:
                        int estoque = inInt("Digite o estoque do produto: ");
                        lista.getListaDeProdutos().get(indice).setEstoque(estoque);
                        break;
                    case 4:
                        int estoqueMinimo = inInt("Digite o novo valor de estoque mínimo do produto: ");
                        lista.getListaDeProdutos().get(indice).setEstoqueMinimo(estoqueMinimo);
                        break;
                    case 5:
                        mostrarTela = false;
                        break;
                    default:
                        break;
                }
            } while(mostrarTela);
            
            if(confereSucessoNaEdicao(produtoAntigo, lista.getListaDeProdutos().get(indice))) {
                System.out.println("\n\n\tEdição efetuada com sucesso!\n");
            }
        }
    }

    // TODO teste
    private boolean verificaListaVazia(List<Produto> p) {
        if(p.isEmpty()) {
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
            return true;
        }
        return false;
    }

    // TODO teste
    private boolean confereSucessoNaEdicao(Produto produtoAntigo, Produto p) {
        return !produtoAntigo.getNome().equals(p.getNome()) || 
        !produtoAntigo.getCodigo().equals(p.getCodigo()) ||
        produtoAntigo.getEstoque() != p.getEstoque() ||
        produtoAntigo.getEstoqueMinimo() != p.getEstoqueMinimo();
    }

    private void excluirProduto() {
        Produto p = null;
        if (lista.getListaDeProdutos().isEmpty()) 
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else {
            String pesquisa = inString("Digite o nome ou código do produto que deseja excluir: ");
            mostraProdutosParaAPesquisa(pesquisa);
            if(numeroDeResultados != 1) {
                System.out.println("\n\n\tExite mais de um produto com '"+pesquisa+"'\n"+
                    "\tPor favor, busque pelo código do produto!");
                    excluirProduto();
            }
            p = listaResultadoDaPesquisa.get(0);
            lista.getListaDeProdutos().remove(p);
        }
        if(!lista.getListaDeProdutos().contains(p)) {
            System.out.println("\n\n\tProduto "+p.getNome()+" excluido com sucesso!\n");
        }
    }
    
    private void pesquisaNaLista(String pesquisa) {
        listaResultadoDaPesquisa.clear();
        numeroDeResultados = 0;
        for (Produto p : lista.getListaDeProdutos()) {
            if(p.getNome().toLowerCase().contains(pesquisa.toLowerCase()) || 
                    p.getCodigo().contains(pesquisa))  {
                listaResultadoDaPesquisa.add(p);
                numeroDeResultados++;
            }
        }
    }

    private void mostraProdutosParaAPesquisa() {
        if (lista.getListaDeProdutos().isEmpty()) 
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else {
            String pesquisa = inString("Digite a chave para pesquisar na lista: ");
            pesquisaNaLista(pesquisa);
            String mensagem = "=========| Exibindo "+numeroDeResultados+" "+
                    ((numeroDeResultados < 2) ? "resultado" : "resultados")+
                    " para '"+pesquisa+"'|=========";
            System.out.println("\n\n\t"+mensagem+"\n\n");
            for (Produto p : listaResultadoDaPesquisa) {
                System.out.println(p+"\n");
            }
            System.out.println("\n\t"+imprimeLinha(mensagem.length()));
        }
    }

    private void mostraProdutosParaAPesquisa(String pesquisa) {
        if (lista.getListaDeProdutos().isEmpty()) 
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else {
            pesquisaNaLista(pesquisa);
            String mensagem = "=========| Exibindo "+numeroDeResultados+" "+
                    ((numeroDeResultados < 2) ? "resultado" : "resultados")+
                    " para '"+pesquisa+"'|=========";
            System.out.println("\n\n\t"+mensagem+"\n\n");
            for (Produto p : listaResultadoDaPesquisa) {
                System.out.println(p+"\n");
            }
            System.out.println("\n\t"+imprimeLinha(mensagem.length()));
        }
    }

    private void mostraEstoque() {
        int posicao = 1;
        if (lista.getListaDeProdutos().isEmpty())
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else { 
            System.out.println("\n\n\t=========| Estoque de produtos: |=========\n\n");
            for (Produto p : lista.getListaDeProdutos()) {
                System.out.println(posicao +"\n"+p+"\n");
                posicao++;
            }
            System.out.println("\t\t\t\t\tTotal de produtos em estoque: "+lista.getListaDeProdutos().size());
            System.out.println("\n\t============================================");
        }
    }
    

    // TODO teste
    public static String inString(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextLine();
    }

    // TODO teste
    public static String inString(String entrada, String fimDeLinha) {
        System.out.print(entrada + fimDeLinha);
        scan = new Scanner(System.in);
        return scan.nextLine();
    }

    // TODO teste
    public static int inInt(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextInt();
    }

    // TODO teste
    public static int inInt(String entrada, String fimDeLinha) {
        System.out.println(entrada + fimDeLinha);
        scan = new Scanner(System.in);
        return scan.nextInt();
    }

    // TODO teste
    public String imprimeLinha(int tamanho) {
        String linha = "";
        for (int i = 0; i < tamanho; i++) {
            linha += "=";
        }
        return linha;
    }
}