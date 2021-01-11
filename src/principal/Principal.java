package principal;

import java.io.IOException;
import java.util.ArrayList;

import produto.Produto;
import userinterface.Ui;
import util.*;

public class Principal {
    public static void main(String[] args) {
        Ui tela = new Ui();
        ManipulaArquivo mArquivo = new ManipulaArquivo();
        try {

            mArquivo.criaArquivo();
            mArquivo.leArquivo();
            tela.setLista(new Lista((ArrayList<Produto>) mArquivo.getLista()));
            tela.menu();
            mArquivo.setLista((ArrayList<Produto>) tela.getLista().getListaDeProdutos());
            mArquivo.escreveArquivo();

        } catch (IOException | InterruptedException e) {
            e.getMessage();
            Thread.currentThread().interrupt();
        }
        System.exit(0);
    }
}