package principal;

import java.io.IOException;
import userinterface.UI;

public class Sistema {
    public static void main(String[] args) {
        UI tela = new UI();
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