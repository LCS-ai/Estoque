package userinterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import produto.*;
import util.*;
import comparadores.*;

public class Ui {
    private Lista lista;
    private List<Produto> listaResultadoDaPesquisa;
    private int numeroDeResultados;

    public Ui() {
        lista = new Lista();
        this.listaResultadoDaPesquisa = new ArrayList<>();
    }


    // TODO exportar as opcões relacionadas ao produto pra um menuProduto
    // TODO adicionar ao menu o metodo de imprimir produtos com estoque baixo.
    public void menu() throws IOException, InterruptedException {
        boolean start = true;
        do {
            lista.atualizaProdutosComEstoqueBaixo();
            LimpaConsole.main(new String[10]);
            imprimeAvisoEstoqueBaixo();
            int opcao = Entrada.inInt("\n=========| Digite a opção desejada |=========\n\n" 
                    + "[1] Visualizar estoque\n" 
                    + "[2] Produto\n"
                    + "[3] Atualiza estoque\n" 
                    + "[4] Visualizar Produtos com Estoque Baixo\n"
                    + "[5] Imprimir Relatório(.txt)\n" 
                    + "[6] Sair\n"
                    + "\n=============================================");
            switch (opcao) {
                case 1:
                    LimpaConsole.main(new String[10]);
                    mostraEstoque();
                    if (Entrada.scanDeParada())
                        break;
                    break;

                case 2:
                    menuDeProduto();
                    break;

                case 3:
                    LimpaConsole.main(new String[10]);
                    atualizaEstoque();
                    if (Entrada.scanDeParada())
                        break;
                    break;

                case 4:
                    LimpaConsole.main(new String[10]);
                    mostraProdutosComEstoqueBaixo();
                    if (Entrada.scanDeParada())
                        break;
                    break;

                case 5:
                    LimpaConsole.main(new String[10]);
                    imprimeRelatorioEmTxt();
                    break;

                case 6:
                    LimpaConsole.main(new String[10]);
                    start = false;
                    break;

                default:
                    break;
            }
        } while (start);
    }

    public void imprimeAvisoEstoqueBaixo() {
        int tamanhoDaLista = lista.getListaDeEstoqueBaixo().size();
        if (tamanhoDaLista > 0) {
            boolean variosProdutos  = tamanhoDaLista > 1;
            String aviso = "\n\t\tATENÇÃO!!!\n" +
                    ((variosProdutos) ? "\n\tExistem " : "\n\tExiste ") +
                    tamanhoDaLista +
                    ((variosProdutos) ? " produtos" : " produto") +
                    " com estoque baixo!";
            System.out.println(retornaLinha(44));
            System.out.println(aviso);
        }
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

    
    public void menuDeProduto() throws IOException, InterruptedException {
        boolean start = true;
        do {
            LimpaConsole.main(new String[10]);
            int opcao = Entrada.inInt("\n=========| Digite a opção desejada |=========\n\n" 
            + "[1] Pesquisar produto\n" 
                    + "[2] Adicionar produto\n" 
                    + "[3] Editar produto\n"
                    + "[4] Apagar produto\n" 
                    + "[5] Voltar\n"
                    + "\n=============================================");
                    switch (opcao) {
                case 1:
                LimpaConsole.main(new String[10]);
                    mostraProdutosParaAPesquisa();
                    if (Entrada.scanDeParada())
                        break;
                    break;

                case 2:
                LimpaConsole.main(new String[10]);
                    adicionaProdutoNaLista();
                    break;
                case 3:
                LimpaConsole.main(new String[10]);
                    editarProduto();
                    if (Entrada.scanDeParada())
                        break;
                    break;
                    
                case 4:
                    LimpaConsole.main(new String[10]);
                    excluirProduto();
                    if (Entrada.scanDeParada())
                        break;
                    break;

                case 5:
                    LimpaConsole.main(new String[10]);
                    start = false;
                    break;

                default:
                    break;
            }
        } while (start);
    }

    private void adicionaProdutoNaLista() {
        String nome;
        String codigo;
        int quantidade;
        int estoqueMinimo;

        nome = Entrada.inString("Digite o nome do produto: ", "");
        codigo = Entrada.inString("Digite o código do produto: ", "");

        if (lista.verificaExistenciaDoProdutoDuasPalavras(nome, codigo))
            System.out.println("\n\n\tProduto " + nome + " com o código " + codigo + " já existe!");
        else {
            int opcao = Entrada.inInt(
                    "\n=========| Digite a opção de cadastro para " + nome + " |=========\n\n"
                    + "[1] Estoque, Estoque mínimo\n" 
                    + "[2] Estoque\n" 
                    + "[3] Finalizar cadastro\n"
                    + "[4] Cancelar cadastro\n" + 
                    "\n================================================");
            switch (opcao) {
                case 1:
                    quantidade = Entrada.inInt("Digite a quantia em estoque: ", "");
                    estoqueMinimo = Entrada.inInt("Digite o estoque mínimo para o produto: ", "");
                    lista.adicionaProduto(new Produto(nome, codigo, quantidade, estoqueMinimo));
                    break;

                case 2:
                    quantidade = Entrada.inInt("Digite a quantia em estoque: ", "");
                    lista.adicionaProduto(new Produto(nome, codigo, quantidade));
                break;

                case 3:
                    lista.adicionaProduto(new Produto(nome, codigo));
                break;

                case 4:
                    System.out.println("\n\n\tCadastro negado pelo usuário!\n\n");
                    if (Entrada.scanDeParada())
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
        String pesquisa = Entrada.inString("Digite o nome ou código do produto que deseja editar: ");
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
            String mensagem = "Não foram encontrados resultados para '" + 
                    pesquisa + "'";
            System.out.println("\n\t" + retornaLinha(mensagem.length() + 16) + "\n");
            System.out.println("\n\t\t" + mensagem + "\n");
            System.out.println("\n\t" + retornaLinha(mensagem.length() + 16) + "\n");
        } else {
            produtoAntigo = lista.getListaDeProdutos().get(indice);
            System.out.println("\n" + produtoAntigo);
            boolean mostrarTela = true;
            do {
                int opcao = Entrada.inInt(
                    "\n==========| Digite a opção de edicão |==========\n\n" 
                        + "[1] Nome\n"
                        + "[2] Código\n" 
                        + "[3] Estoque\n" 
                        + "[4] Estoque mínimo\n" 
                        + "[5] Voltar\n"
                        + "\n================================================");
                switch (opcao) {
                    case 1:
                        String nome = Entrada.inString("Digite o novo nome para o produto: ", "");
                        lista.getListaDeProdutos().get(indice).setNome(nome);
                        break;
                    case 2:
                        String codigo = Entrada.inString("Digite o novo codigo para o produto: ", "");
                        lista.getListaDeProdutos().get(indice).setCodigo(codigo);
                        break;
                    case 3:
                        int estoque = Entrada.inInt("Digite o estoque do produto: ", "");
                        lista.getListaDeProdutos().get(indice).setEstoque(estoque);
                        break;
                    case 4:
                        int estoqueMinimo = Entrada.inInt("Digite o novo valor de estoque mínimo do produto: ", "");
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
                Entrada.scanDeParada();
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
    
    private void atualizaEstoque() {
        if(!verificaListaVazia(lista.getListaDeProdutos())) {
            String pesquisa = Entrada.inString("Digite o produto que gostaria de atualizar o estoque: ");
            int indice = lista.pesquisaProduto(pesquisa);
            pesquisaNaLista(pesquisa);
            if (numeroDeResultados > 1) {
                mostraProdutosParaAPesquisa(pesquisa);
                System.out.println("\n\n\tExiste mais de um produto com '" + pesquisa + "'\n"
                + "\tPor favor, busque pelo código do produto!");
                atualizaEstoque();
            }

            if (indice < 0) {
                String mensagem = "Não foram encontrados resultados para '" + 
                        pesquisa + "'";
                System.out.println("\n\t" + retornaLinha(mensagem.length() + 16) + "\n");
                System.out.println("\n\t\t" + mensagem + "\n");
                System.out.println("\n\t" + retornaLinha(mensagem.length() + 16) + "\n");
            } else {
                Produto p;
                p = menuAtualizacaoDeEstoque(lista.retornaProduto(indice));
                lista.getListaDeProdutos().set(indice, p);
            }
        }
    }
    
    
    public Produto menuAtualizacaoDeEstoque(Produto p) {
        boolean mostrarTela = true;
        int quantidade = 0;
        do {
            String mensagem = "==========| Digite a opção de atualização para "+p.getNome()+" |==========";
            int opcao = Entrada.inInt(
                "\n"+mensagem+"\n\n" 
                    + "[1] Dar ENTRADA no estoque\n"
                    + "[2] Dar SAIDA no estoque\n" 
                    + "[3] Voltar\n"
                    + "\n"+retornaLinha(mensagem.length()));
            switch (opcao) {
                case 1:
                    quantidade = Entrada.inInt("Digite a quantidade de produtos que irão entrar no estoque: ", "");
                    daEntradaNoEstoque(quantidade, p);
                    break;
                case 2:
                    quantidade = Entrada.inInt("Digite a quantidade de produtos que irão sair do estoque: ", "");
                    daSaidaNoEstoque(quantidade, p);
                    break;
                case 3:
                    mostrarTela = false;
                    break;
                default:
                    break;
            }
            
        } while (mostrarTela);
        return p;
    }
    
    public boolean liberaSaidaDoEstoque(int quantidade, Produto p) {
        return ((p.getEstoque() - quantidade) > 0);
    }

    public Produto daEntradaNoEstoque(int quantidade, Produto p) {
            p.setEstoque(p.getEstoque() + quantidade);
            return p;
    }

    public Produto daSaidaNoEstoque(int quantidade, Produto p) {
        if(liberaSaidaDoEstoque(quantidade, p)) {
            p.setEstoque(p.getEstoque() - quantidade);
        }
        return p;
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
        return !produtoAntigo.getNome().equals(p.getNome()) || 
                !produtoAntigo.getCodigo().equals(p.getCodigo()) || 
                produtoAntigo.getEstoque() != p.getEstoque()||
                produtoAntigo.getEstoqueMinimo() != p.getEstoqueMinimo();
    }

    private void excluirProduto() {
        Produto p = null;
        if (lista.getListaDeProdutos().isEmpty())
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else {
            String pesquisa = Entrada.inString("Digite o nome ou código do produto que deseja excluir: ");
            mostraProdutosParaAPesquisa(pesquisa);
            if (numeroDeResultados != 1) {
                System.out.println("\n\n\tExite mais de um produto com '" + pesquisa + "'\n"
                        + "\tPor favor, busque pelo código do produto!");
                excluirProduto();
            }
            p = listaResultadoDaPesquisa.get(0);
            lista.getListaDeProdutos().remove(p);

            if (!lista.getListaDeProdutos().contains(p) ) {
                System.out.println("\n\n\tProduto " + p.getNome() + " excluido com sucesso!\n");
            }
        }
    }

    private void pesquisaNaLista(String pesquisa) {
        if(listaResultadoDaPesquisa != null) {
            listaResultadoDaPesquisa.clear();
        }
        numeroDeResultados = 0;
        for (Produto p : lista.getListaDeProdutos()) {
            if (p.getNome().toLowerCase().contains(pesquisa.toLowerCase()) 
                    || p.getCodigo().contains(pesquisa)) {
                listaResultadoDaPesquisa.add(p);
                numeroDeResultados++;
            }
        }
    }

    private void mostraProdutosParaAPesquisa() {
        if (lista.getListaDeProdutos().isEmpty())
            System.out.println("\n\n\tAinda não há produtos cadastrados!\n");
        else {
            String pesquisa = Entrada.inString("Digite a chave para pesquisar na lista: ", "");
            pesquisaNaLista(pesquisa);
            String mensagem = (numeroDeResultados < 1) ? 
                    "Não foram encontrados resultados para '" + pesquisa + "'"
                    : "=========| Exibindo " + numeroDeResultados + " "
                    + ((numeroDeResultados < 2) ? "resultado" : "resultados") 
                    + " para '" + pesquisa + "'|=========";
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

    private void mostraProdutosComEstoqueBaixo() {
        if (lista.getListaDeProdutos().isEmpty())
            System.out.println("\n\n\tNão há produtos com estoque baixo!\n");
        else {
            int posicao = 1;
            Collections.sort(new ComparadorPorEstoque());
            String mensagem = "=================| Produtos em estoque baixo: |=================";
            System.out.println("\n\n\t" + mensagem + "\n\n");
            for (Produto p : lista.getListaDeEstoqueBaixo()) {
                System.out.println(posicao + " ------\n" + p + "\n");
                posicao++;
            }
            System.out.println("\t\t\t\tTotal de produtos em estoque: " + lista.getListaDeEstoqueBaixo().size());
            System.out.println("\n\t" + retornaLinha(mensagem.length()) + "\n");
        }
    }

    public String retornaLinha(int tamanho) {
        StringBuilder linha = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            linha.append("=");
        }
        return linha.toString();
    }

}
