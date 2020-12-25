package util;

import java.util.Scanner;

public class Entrada {

    private static Scanner scan;

    private Entrada() {
        
    }

    public static boolean scanDeParada() {
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

    public static double inDouble(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextDouble();
    }
    
}
