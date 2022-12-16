package locadoraJogo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    public static int getInt(String mensage, String errorMessage) {
        Scanner sc = new Scanner(System.in);
        int result;
        while (true) {
            System.out.println(mensage);
            try {
                result = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
            }
            sc.nextLine();
        }
        return result;
    }

    public static long getlong(String mensage, String errorMensage) {
        Scanner sc = new Scanner(System.in);
        long result;
        while (true) {
            System.out.println(mensage);
            try {
                result = sc.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println(errorMensage);
            }
            sc.nextLine();
        }
        return result;
    }

    public static String getString(String mensagem) {
        Scanner sc = new Scanner(System.in);
        String result;
        System.out.print(mensagem);
        result = sc.nextLine();
        return result;
    }
    }