package util;

import java.io.IOException;

public class LimpaConsole {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(System.getProperty("os.name").contains("Windows")) 
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }
}
