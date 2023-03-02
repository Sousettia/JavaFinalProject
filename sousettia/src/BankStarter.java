import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
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
        loginandregister();
        homepage();
    }
    public static void loginandregister() throws IOException {
        Customer customer = new Customer();

        boolean loop = false;
        do {
            System.out.println("WHITESWAN BANK" + 
                            "\n------------------------------------\n1. Login\n2. Register");
            System.out.println("------------------------------------");

            System.out.print("Please select a number : ");
            String select = scan.next();
    
            System.out.println();
            switch(select){
                case "1" :
                    if(customer.login()){
                        System.out.println("LOGIN SUCCEED\n");
                    }else{
                        System.out.println("LOGIN FAILED\n");
                    }
                    break;
                case "2" :
                    if(customer.register()){
                        System.out.println("REGISTER SUCCEED\n");
                    }else{
                        System.out.println("REGISTER FAILED\n");
                    }
                    break;
                default :
                    System.out.println("Wrong number, Please select 1-2 only\n");
                    loop = true;
                    break;
            }
        } while (loop);
    }
    public static void homepage() throws IOException {
        while(true){
            System.out.println("HOME PAGE" + 
                            "\n------------------------------------\n1. HomePage\n2. BookBank\n3. Transfer\n4. Currency\n");

            System.out.print("Please select a number : ");
            String select = scan.next();

            switch(select){
                case "1" :
                    break;
                case "2" : 
                    Bookbank();
                    break;
                case "3" :
                    Transfer();
                    break;
                case "4" :
                    Currency();
                    break;
                default :
                    System.out.println("Please Input The Correct Number.");
                    break;
            }
        }
    }
    public static void Bookbank() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("src/DataStorage/CustomerData.sqlite"));
        String temp = "";
        while((temp = read.readLine()) != null){
            String[] data = temp.split("\\|");
            System.out.println(MessageFormat.format(
                "Customer Detail : \nName : {0}\nAddress : {1}\nEmail : {2}"
                , (data[2] + data[3]),data[5],data[0]));
        }
    }
    public static void Transfer() {

    }
    public static void Currency() {
        
    }
}
