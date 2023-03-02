package BACKEND;

import java.io.IOException;
import java.util.Scanner;

public class BankStarter {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        try {
            run();
        } catch (Exception e) {
            e.toString();
        }
    }
    public static void run() throws IOException {
        HomePage run = new HomePage();
        run.loginandregister();
        run.homepage();
    }
}
