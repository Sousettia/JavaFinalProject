package BACKEND;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
        this(0,null,null, null, null, null, null);
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
    public Customer(String email, String password, String firstName, String lastName,String identificationID,
            String address) {
        this(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationID = identificationID;
        this.address = address;
    }
    public Customer(int account_no,String email, String password, String firstName, String lastName,String identificationID,
            String address) {
        this(email, password, firstName, lastName, identificationID, address);
        this.account_no = account_no;
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
    public void setString(String email, String password, String fName, String lName, String id, String address){
        this.email = email;
        this.password = password;
        this.firstName = fName;
        this.lastName = lName;
        this.identificationID = id;
        this.address = address;
    }

    //#endregion
    static Scanner scan = new Scanner(System.in);

    public boolean login(String email,String password) throws IOException{
        setEmail(email); setPassword(password);
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
    public boolean register_enpcheck(String email,String password,String confirmpassword){
        setEmail(email); setPassword(password); setConfirmPassword(confirmpassword);
        boolean check = false;
        if(checkEmail() && checkPassword()){
            check = true;
        }
        if(check){
            return true;
        }
        return false;
    }
    public boolean checkEmail() {
        if(this.email.endsWith("@gmail.com") || this.email.endsWith("@hotmail.com")){
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
    public boolean idcheck(String id){
        boolean IDcheck = false;
        if(id.length() == 13){
            for(int i = 0 ; i < id.length(); i++){
                if(Character.isDigit(id.charAt(i))){
                    IDcheck = true;
                }else{
                    IDcheck = false;
                    break;
                }
            }
        }   
        return IDcheck;
    }
    public void register(String email, String password, String fName, String lName, String id, String address) throws IOException{
        File theFile = new File("DataStorage/Account.json");
        ArrayList<Customer> theList;
        setString(email, password, fName, lName, id, address);
        if(theFile.exists()){
            try {
                FileReader fileReader = new FileReader(theFile);
                Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
                Gson gson = new Gson();
                theList = gson.fromJson(fileReader, type);
                fileReader.close();

                List<Integer> acc_list = new ArrayList<>();
                for(Customer c : theList){
                    acc_list.add(c.getAccount_no());
                }
                setAccount_no(Collections.max(acc_list)+1);
                
                FileWriter write = new FileWriter(theFile);
                Gson writegson = new Gson();
                theList.add(new Customer(getAccount_no(),getEmail(),getPassword(),getFirstName(),getLastName(),getidentificationID(),getAddress()));
                writegson.toJson(theList, write);
                write.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                FileWriter write = new FileWriter(theFile);
                Gson gson = new Gson();
                setAccount_no(1);
                theList = new ArrayList<>();
                theList.add(new Customer(getAccount_no(),getEmail(),getPassword(),getFirstName(),getLastName(),getidentificationID(),getAddress()));
                gson.toJson(theList, write);
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void Header(String msg){
        System.out.println("\t\t" + msg);
        for(int i = 1; i <= 49; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}
