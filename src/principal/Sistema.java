package principal;

import java.io.IOException;
import userinterface.Ui;

public class Sistema {
    public static void main(String[] args) {
        Ui tela = new Ui();
        try {
            tela.menu();
        } catch (IOException e) {
            e.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.exit(0);
    }
}