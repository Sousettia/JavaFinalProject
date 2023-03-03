package BACKEND;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;

public class Customer {
    //#region attributes
    private String identificationID;
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String address;
    private int account_no;

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
    public Customer(int account_no,String email, String password, String firstName, String lastName,String identificationID,
            String address) {
        this.account_no = account_no;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationID = identificationID;
        this.address = address;
    }
    //#endregion
    //#region setters and getters
    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }
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
    public boolean login(String email,String password) throws IOException{
        setEmail(email);
        setPassword(password);
        BufferedReader read = new BufferedReader(new FileReader("DataStorage/CustomerData.sqlite"));
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
    /* 
    public boolean register2() throws IOException{
        Header("REGISTER");
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
  
        return false;
    }
    */
    public boolean register() throws IOException{
        Header("REGISTER");
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
        } while (!IDcheck);
        System.out.print("Address : ");
        scan.nextLine();
        setAddress(scan.nextLine());
        System.out.println();
    
        try {
            File theFile = new File("DataStorage/Account.json");
            FileWriter write = new FileWriter(theFile);
            Gson writegson = new Gson();
            ArrayList<Customer> theList = new ArrayList<>();
            theList.add(new Customer(getAccount_no(),getEmail(),getPassword(),getFirstName(),getLastName(),getidentificationID(),getAddress()));
            writegson.toJson(theList, write);
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
