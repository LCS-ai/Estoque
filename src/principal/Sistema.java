package principal;

import java.io.IOException;
import userinterface.Ui;

public class Sistema {
    public static void main(String[] args) {
        Ui tela = new Ui();
        try {
            tela.menu();
        } catch (IOException | InterruptedException e) {
            e.getMessage();
            Thread.currentThread().interrupt();
        }
        System.exit(0);
    }
}