package userinterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import produto.*;
import util.*;

public class Ui {
    private Lista lista;
    private static Scanner scan;
    private List<Produto> listaResultadoDaPesquisa;
    private int numeroDeResultados;

    public Ui() {
        lista = new Lista();
    }

    public void menu() throws IOException, InterruptedException {
        boolean start = true;
        do {
            LimpaConsole.main(new String[10]);
            int opcao = inInt("\n=========| Digite a opção desejada |=========\n\n" + "[1] Visualizar estoque\n"
                    + "[2] Pesquisar produto\n" + "[3] Adicionar produto\n" + "[4] Editar produto\n"
                    + "[5] Apagar produto\n" + "[6] Sair\n" + "\n=============================================");
            switch (opcao) {
                case 1:
                    LimpaConsole.main(new String[10]);
                    mostraEstoque();
                    if (scanDeParada())
                        break;
                    break;
                case 2:
                    LimpaConsole.main(new String[10]);
                    mostraProdutosParaAPesquisa();
                    if (scanDeParada())
                        break;
                    break;
                case 3:
                    LimpaConsole.main(new String[10]);
                    adicionaProdutoNaLista();
                    break;
                case 4:
                    LimpaConsole.main(new String[10]);
                    editarProduto();
                    if (scanDeParada())
                        break;
                    break;
                case 5:
                    LimpaConsole.main(new String[10]);
                    excluirProduto();
                    if (scanDeParada())
                        break;
                    break;
                case 6:
                    LimpaConsole.main(new String[10]);
                    start = false;
                    break;

                case 7:
                    LimpaConsole.main(new String[10]);
                    atualizaEstoque();
                    break;

                case 8:
                    LimpaConsole.main(new String[10]);
                    imprimeRelatorioEmTxt();
                    break;

                default:
                    break;
            }
        } while (start);
    }

    private void imprimeRelatorioEmTxt() {
        String path = "C:\\temp\\relatorio.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            if (lista.tamanhoDalistaDeProdutos() > 0) {
                bw.write("------------ LISTA DE PRODUTOS ------------");
                bw.newLine();
                for (int i = 0; i < lista.tamanhoDalistaDeProdutos(); i++) {
                    bw.write(lista.retornaProduto(i).toString());
                    bw.newLine();
                }
            }
            if (lista.tamanhoDalistaDeProdutosVendidos() > 0) {
                bw.write("----------- PRODUTOS VENDIDOS ------------");
                for (int j = 0; j < lista.tamanhoDalistaDeProdutos(); j++) {
                    bw.write(lista.retornaProdutoVendido(j).toString());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void atualizaEstoque() {
        String buscaPeloProduto = inString("Digite o produto que gostaria de atualizar o estoque: ");
        if (lista.verificaExistenciaDoProduto(buscaPeloProduto)) {
            int estoque = inInt("Digite a quantia de produtos que irão sair do estoque.");
            lista.retornaProduto(lista.pesquisaProduto(buscaPeloProduto)).liberaVenda(estoque);
        }

        else {
            System.out.println("Produto não encontrado.");
        }
    }
    
    private void adicionaProdutoNaLista() {
        String nome;
        String codigo;
        int quantidade;
        int estoqueMinimo;

        nome = inString("Digite o nome do produto: ", "");
        codigo = inString("Digite o código do produto: ", "");

        if (lista.verificaExistenciaDoProdutoDuasPalavras(nome, codigo))
            System.out.println("\n\n\tProduto " + nome + " com o código " + codigo + " já existe!");
        else {
            int opcao = inInt("\n=========| Digite a opção de cadastro para "+nome+" |=========\n\n"
                    + "[1] Estoque, Estoque mínimo\n" + "[2] Estoque\n"
                    + "[3] Finalizar cadastro\n" + "[4] Cancelar cadastro\n"
                    + "\n================================================");
            switch (opcao) {
                case 1:                    
                    quantidade = inInt("Digite a quantia em estoque: ", "");
                    estoqueMinimo = inInt("Digite o estoque mínimo para o produto: ", "");
                    lista.adicionaProduto(new Produto(nome, codigo, quantidade, estoqueMinimo));
                    break;

                case 2:                    
                    quantidade = inInt("Digite a quantia em estoque: ", "");
                    lista.adicionaProduto(new Produto(nome, codigo, quantidade));
                    break;

                case 3:                    
                    lista.adicionaProduto(new Produto(nome, codigo));
                    break;

                case 4:
                    System.out.println("\n\n\tCadastro negado pelo usuário!\n\n");
                    if (scanDeParada())
                        break;
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
        int indice = lista.pesquisaProduto(pesquisa);
        pesquisaNaLista(pesquisa);
        if (numeroDeResultados > 1) {
            mostraProdutosParaAPesquisa(pesquisa);
            System.out.println("\n\n\tExiste mais de um produto com '" + pesquisa + "'\n"
                    + "\tPor favor, busque pelo código do produto!");
            menuDeEdicao();
        }
        Produto produtoAntigo;
        if (indice < 0) {
            String mensagem = "Não foram encontrados resultados para '" + pesquisa + "'";
            System.out.println("\n\t" + retornaLinha(mensagem.length() + 16) + "\n");
            System.out.println("\n\t\t" + mensagem + "\n");
            System.out.println("\n\t" + retornaLinha(mensagem.length() + 16) + "\n");
        } else {
            produtoAntigo = lista.getListaDeProdutos().get(indice);
            System.out.println("\n" + produtoAntigo);
            boolean mostrarTela = true;
            do {
                int opcao = inInt("\n==========| Digite a opção de edicão |==========\n\n" + "[1] Nome\n"
                        + "[2] Código\n" + "[3] Estoque\n" + "[4] Estoque mínimo\n" + "[5] Voltar\n"
                        + "\n================================================");
                switch (opcao) {
                    case 1:
                        String nome = inString("Digite o novo nome para o produto: ", "");
                        lista.getListaDeProdutos().get(indice).setNome(nome);
                        break;
                    case 2:
                        String codigo = inString("Digite o novo codigo para o produto: ", "");
                        lista.getListaDeProdutos().get(indice).setCodigo(codigo);
                        break;
                    case 3:
                        int estoque = inInt("Digite o estoque do produto: ", "");
                        lista.getListaDeProdutos().get(indice).setEstoque(estoque);
                        break;
                    case 4:
                        int estoqueMinimo = inInt("Digite o novo valor de estoque mínimo do produto: ", "");
                        lista.getListaDeProdutos().get(indice).setEstoqueMinimo(estoqueMinimo);
                        break;
                    case 5:
                        mostrarTela = false;
                        break;
                    default:
                        break;
                }

            } while (mostrarTela);

            if (confereSucessoNaEdicao(produtoAntigo, lista.getListaDeProdutos().get(indice))) {
                System.out.println("\n\n\tEdição efetuada com sucesso!\n");
                scanDeParada();
            }
        }
    }

    /**
     * Metodo que recebe uma lista, verifica se ela esta vazia atraves da funcao
     * isEmpty() da API Java e retorna o valor booleano da conferencia. Ainda
     * retorna para o usuario um feedback caso a lista esteja vazia.
     * 
     * @param p
     * @return
     */
    public boolean verificaListaVazia(List<Produto> p) {
        if (p.isEmpty()) {
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
            return true;
        }
        return false;
    }

    /**
     * Metodo recebe dois produtos respectivos ao produto antes de ser editado e
     * apos a edicao. Ele confere cada atributo do produtos buscando por alteracoes
     * e retorna o valor booleano das comparacoes.
     * 
     * @param produtoAntigo : Produto
     * @param p             : Produto
     * @return : boolean
     */
    public boolean confereSucessoNaEdicao(Produto produtoAntigo, Produto p) {
        return !produtoAntigo.getNome().equals(p.getNome()) || !produtoAntigo.getCodigo().equals(p.getCodigo())
                || produtoAntigo.getEstoque() != p.getEstoque()
                || produtoAntigo.getEstoqueMinimo() != p.getEstoqueMinimo();
    }

    private void excluirProduto() {
        Produto p = null;
        if (lista.getListaDeProdutos().isEmpty())
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else {
            String pesquisa = inString("Digite o nome ou código do produto que deseja excluir: ");
            mostraProdutosParaAPesquisa(pesquisa);
            if (numeroDeResultados != 1) {
                System.out.println("\n\n\tExite mais de um produto com '" + pesquisa + "'\n"
                        + "\tPor favor, busque pelo código do produto!");
                excluirProduto();
            }
            p = listaResultadoDaPesquisa.get(0);
            lista.getListaDeProdutos().remove(p);
        }
        if (!lista.getListaDeProdutos().contains(p)) {
            System.out.println("\n\n\tProduto " + p.getNome() + " excluido com sucesso!\n");
        }
    }

    private void pesquisaNaLista(String pesquisa) {
        listaResultadoDaPesquisa.clear();
        numeroDeResultados = 0;
        for (Produto p : lista.getListaDeProdutos()) {
            if (p.getNome().toLowerCase().contains(pesquisa.toLowerCase()) || p.getCodigo().contains(pesquisa)) {
                listaResultadoDaPesquisa.add(p);
                numeroDeResultados++;
            }
        }
    }

    private void mostraProdutosParaAPesquisa() {
        if (lista.getListaDeProdutos().isEmpty())
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else {
            String pesquisa = inString("Digite a chave para pesquisar na lista: ", "");
            pesquisaNaLista(pesquisa);
            String mensagem = (numeroDeResultados < 1) ? "Não foram encontrados resultados para '" + pesquisa + "'"
                    : "=========| Exibindo " + numeroDeResultados + " "
                            + ((numeroDeResultados < 2) ? "resultado" : "resultados") + " para '" + pesquisa
                            + "'|=========";
            if (numeroDeResultados < 1)
                System.out.println("\n\t" + retornaLinha(mensagem.length()) + "\n");
            System.out.println("\n\n\t" + mensagem + "\n\n");
            for (Produto p : listaResultadoDaPesquisa) {
                System.out.println(p + "\n");
            }
            System.out.println("\n\t" + retornaLinha(mensagem.length()));
        }
    }

    private void mostraProdutosParaAPesquisa(String pesquisa) {
        if (lista.getListaDeProdutos().isEmpty())
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else {
            pesquisaNaLista(pesquisa);
            String mensagem = (numeroDeResultados < 1) ? "Não foram encontrados resultados para '" + pesquisa + "'"
                    : "=========| Exibindo " + numeroDeResultados + " "
                            + ((numeroDeResultados < 2) ? "resultado" : "resultados") + " para '" + pesquisa
                            + "'|=========";
            if (numeroDeResultados < 1)
                System.out.println("\n\t" + retornaLinha(mensagem.length()) + "\n");
            System.out.println("\n\n\t" + mensagem + "\n\n");
            for (Produto p : listaResultadoDaPesquisa) {
                System.out.println(p + "\n");
            }
            System.out.println("\n\t" + retornaLinha(mensagem.length()));
        }
    }

    private void mostraEstoque() {
        int posicao = 1;
        if (lista.getListaDeProdutos().isEmpty())
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else {
            String mensagem = "=================| Estoque de produtos: |=================";
            System.out.println("\n\n\t" + mensagem + "\n\n");
            for (Produto p : lista.getListaDeProdutos()) {
                System.out.println(posicao + " ------\n" + p + "\n");
                posicao++;
            }
            System.out.println("\t\t\t\tTotal de produtos em estoque: " + lista.getListaDeProdutos().size());
            System.out.println("\n\t" + retornaLinha(mensagem.length()) + "\n");
        }
    }

    public boolean scanDeParada() {
        String entrada = inString();
        return (entrada.equals("") || entrada.isBlank());
    }

    public static String inString() {
        scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static String inString(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static String inString(String entrada, String fimDeLinha) {
        System.out.print(entrada + fimDeLinha);
        scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static int inInt(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static int inInt(String entrada, String fimDeLinha) {
        System.out.print(entrada + fimDeLinha);
        scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public String retornaLinha(int tamanho) {
        StringBuilder linha = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            linha.append("=");
        }
        return linha.toString();
    }
}
