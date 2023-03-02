import java.io.*;
import java.text.MessageFormat;
import java.util.*;

public class Customer {
    //#region attributes
    private String identificationID;
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String address;
    //#endregion
    //#region Constructors
    public Customer() {
        this.email = this.password = this.confirmPassword = null;
        this.identificationID = this.firstName = this.lastName = this.address = null;
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Customer(String email, String password,String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    //#endregion
    //#region setters and getters
    public String getidentificationID() {
        return identificationID;
    }

    public void setidentificationID(String identificationID) {
        this.identificationID = identificationID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //#endregion
    static Scanner scan = new Scanner(System.in);
    public boolean login() throws IOException{
        Header("LOGIN");

        System.out.print("Email : ");
        setEmail(scan.next());
        System.out.print("Password : ");
        setPassword(scan.next());

        BufferedReader read = new BufferedReader(new FileReader("src/DataStorage/CustomerData.sqlite"));
        String temp = "";
        while((temp = read.readLine()) != null){
            String[] data = temp.split("\\|");

            if(getEmail().equals(data[0]) && getPassword().equals(data[1])){
                read.close();
                return true;
            }          
        }
        read.close();
        return false;
                
    }
    public boolean register() throws IOException{
        Header("REGISTER");
        PrintWriter write = new PrintWriter(new FileWriter("src/DataStorage/CustomerData.sqlite", true));
        boolean check = false;
        do{
            System.out.print("Email : ");
            setEmail(scan.next());
            System.out.print("Password : ");
            setPassword(scan.next());
            System.out.print("Confirm password : ");
            setConfirmPassword(scan.next());
            
            if(checkEmail() && checkPassword()){
                check = true;
            }else{
                System.out.println("Email or Password or ConfirmPassword is incorrect");
            }
            System.out.println();
        }while(!check);

        boolean IDcheck = false;
        do {
            System.out.print("FirstName : ");
            setFirstName(scan.next());
            System.out.print("LastName : ");
            setLastName(scan.next());
    
            System.out.print("Identification ID : ");
            setidentificationID(scan.next());
    
            String IDtemp = getidentificationID();
            if(IDtemp.length() == 13){
                for(int i = 0 ; i < IDtemp.length(); i++){
                    if(Character.isDigit(IDtemp.charAt(i))){
                        IDcheck = true;
                    }else{
                        IDcheck = false;
                        System.out.println("ID is incorrect format");
                        break;
                    }
                }
            }   
        } while (IDcheck == false);
        System.out.print("Address : ");
        scan.nextLine();
        setAddress(scan.nextLine());
        System.out.println();
        
        write.println(MessageFormat.format("{0}|{1}|{2}|{3}|{4}|{5}", email,password,firstName,lastName,identificationID,address));
        write.close();
        if(check){
            return true;
        }
        return false;
    }
    
    public void Header(String msg){
        System.out.println("\t\t" + msg);
        for(int i = 1; i <= 49; i++){
            System.out.print("*");
        }
        System.out.println();
    }

    public boolean checkEmail() {
        if(this.email.endsWith("@gmail.com")){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkPassword() {
        if(password.equals(confirmPassword)){
            return true;
        }
        else{
            return false;
        }
    }
    
}
