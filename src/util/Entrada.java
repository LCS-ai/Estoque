package util;

import java.util.Scanner;

public class Entrada {

    private Scanner scan;

    public Entrada (){     
    }

    public String inString(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public int inInt(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public double inDouble(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextDouble();
    }
    
}
