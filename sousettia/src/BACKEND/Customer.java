package BACKEND;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataStorage.temp_acc_class;

public class Customer {
    //#region attributes
    private String identificationID;
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String address;
    private String dmy;
    private String gender;
    private String postal;
    private String phone;
    private ArrayList<String> customer_account_data;
    private ArrayList<Object> transactionList;

    //#endregion
    //#region Constructors
    public Customer() {
        this(null,null, null, null, null, null);
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

    public Customer(String email, String password, String fName, String lName, 
                            String id, String address, String dmy, String gender, String postal, String phone){
        this(email, password, fName, lName, id, address);
        this.dmy = dmy;
        this.gender = gender;
        this.postal = postal;
        this.phone = phone;
    }

    // public Customer(int account_no) {
    //     this.account_no = account_no;
    // }

    //#endregion
    //#region setters and getters
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDmy() {
        return dmy;
    }

    public void setDmy(String dmy) {
        this.dmy = dmy;
    }
    // public int getAccount_no() {
    //     return account_no;
    // }

    // public void setAccount_no(int account_no) {
    //     this.account_no = account_no;
    // }
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
    public void setString(String email, String password, String fName, String lName, 
                            String id, String address, String dmy, String gender, String postal, String phone){
        this.email = email;
        this.password = password;
        this.firstName = fName;
        this.lastName = lName;
        this.identificationID = id;
        this.address = address;
        this.dmy = dmy;
        this.gender = gender;
        this.postal = postal;
        this.phone = phone;
    }
    public ArrayList<String> getCustomer_account_data() {
        return customer_account_data;
    }

    public void setCustomer_account_data(ArrayList<String> customer_account_data) {
        this.customer_account_data = customer_account_data;
    }

    public ArrayList<Object> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(String statement,double amount) {
        transactionList.add(new temp_acc_class());
    }

    //#endregion
    static Scanner scan = new Scanner(System.in);

    public boolean login(String email,String password) throws IOException{
        setEmail(email); setPassword(password);
        File theFile = new File("DataStorage/Account.json");
        ArrayList<Customer> theList; 
        try {
            FileReader fileReader = new FileReader(theFile);
            Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
            Gson gson = new Gson();
            theList = gson.fromJson(fileReader, type);
            fileReader.close();

            for(Customer c : theList){
                if(this.getEmail().equals(c.getEmail()) && this.getPassword().equals(c.getPassword())){
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void register(String email, String password, String fName, String lName, 
                            String id, String address, String dmy, String gender, String postal, String phone) throws IOException{
        File theFile = new File("DataStorage/Account.json");
        ArrayList<Customer> theList;
        setString(email, password, fName, lName, id, address, dmy, gender, postal, phone);
        if(theFile.exists()){
            try {
                FileReader fileReader = new FileReader(theFile);
                Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
                Gson gson = new Gson();
                theList = gson.fromJson(fileReader, type);
                fileReader.close();

                // List<Integer> acc_list = new ArrayList<>();
                // for(Customer c : theList){
                //     acc_list.add(c.getAccount_no());
                // }
                // setAccount_no(Collections.max(acc_list)+1);
                
                FileWriter write = new FileWriter(theFile);
                Gson writegson = new Gson();
                theList.add(new Customer(getEmail(),getPassword(),getFirstName(),getLastName(),getidentificationID(),getAddress()
                                            ,getDmy(),getGender(),getPostal(),getPhone()));
                writegson.toJson(theList, write);
                write.close();

                //--------------------------------------------------------------------------------------

                /* accountlistwrite after file was created
                FileReader seconFileReader = new FileReader(new File("DataStorage/allaccountlist.json"));
                Type secondtype = new TypeToken<ArrayList<Customer>>(){}.getType();
                Gson secondgson = new Gson();
                theList = secondgson.fromJson(seconFileReader, secondtype);
                fileReader.close();

                List<Integer> secondacc_list = new ArrayList<>();
                for(Customer c : theList){
                    secondacc_list.add(c.getAccount_no());
                }
                setAccount_no(Collections.max(secondacc_list)+1);

                FileWriter secondwrite = new FileWriter(new File("DataStorage/allaccountlist.json"));
                Gson secondwritegson = new Gson();
                theList.add(new Customer(getAccount_no()));
                secondwritegson.toJson(theList,secondwrite);
                secondwrite.close();
                */
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                FileWriter write = new FileWriter(theFile);
                Gson gson = new Gson();
                theList = new ArrayList<>();
                theList.add(new Customer(getEmail(),getPassword(),getFirstName(),getLastName(),getidentificationID(),getAddress()
                                         ,getDmy(),getGender(),getPostal(),getPhone()));
                gson.toJson(theList, write);
                write.close();

                /*
                FileWriter secondwrite = new FileWriter(new File("DataStorage/allaccountlist.json"));
                Gson secondgson = new Gson();
                theList = new ArrayList<>();
                theList.add(new Customer(getAccount_no()));
                secondgson.toJson(theList,secondwrite);
                secondwrite.close(); 
                */
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void CreateAccount() throws IOException {
        // File theFile = new File("DataStorage/Account.json");
        // ArrayList<Customer> theList;
            
        // if(theFile.exists()){
        //     try {
        //         FileReader fileReader = new FileReader(theFile);
        //         Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
        //         Gson gson = new Gson();
        //         theList = gson.fromJson(fileReader, type);
        //         fileReader.close();

        //         // customer_account_data = new ArrayList<>();
        //         // for(Customer c : theList){
        //         //     customer_account_data.add("First Name : "+c.getFirstName());
        //         //     customer_account_data.add("Last Name  : "+c.getLastName());
        //         //     customer_account_data.add("Address    : "+c.getAddress());
        //         //     customer_account_data.add("Email      : "+c.getEmail());
        //         // }
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }
    }
    public boolean emptyfieldcheck(String email, String password, String fName, String lName, String id, String address, 
                                    String dmy, String gender, String postal, String phone){
        setString(email, password, fName, lName, id, address, dmy, gender, postal, phone);
        
        return false;
    }
}

