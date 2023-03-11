package BACKEND;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
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
        transactionList.add(new PersonalAccountData());
    }
    
    //#endregion
    static Scanner scan = new Scanner(System.in);

    public boolean login(String email,String password) throws IOException{
        setEmail(email); setPassword(password);
        File theFile = new File("DataStorage/Customer.json");
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
    public boolean postalcheck(String postal){
        boolean Postalcheck = false;
        if(postal.length() == 5){
            for(int i = 0 ; i < postal.length(); i++){
                if(Character.isDigit(postal.charAt(i))){
                    Postalcheck = true;
                }else{
                    Postalcheck = false;
                    break;
                }
            }
        }   
        return Postalcheck;
    }
    public boolean phonecheck(String phone){
        boolean Phonecheck = false;
        if(phone.length() == 10 && phone.startsWith("0")){
            for(int i = 0 ; i < phone.length(); i++){
                if(Character.isDigit(phone.charAt(i))){
                    Phonecheck = true;
                }else{
                    Phonecheck = false;
                    break;
                }
            }
        }   
        return Phonecheck;
    }
    public void register(String email, String password, String fName, String lName, 
                            String id, String address, String dmy, String gender, String postal, String phone) throws IOException{

        setString(email, password, fName, lName, id, address, dmy, gender, postal, phone);
        CustomerJsonCreate();
        CustomerwithAccountJsonCreate();
    }
    public void CustomerJsonCreate() throws IOException{
        File theFile = new File("DataStorage/Customer.json");
        ArrayList<Customer> theList;
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
                theList.add(new Customer(getEmail(),getPassword(),getFirstName(),getLastName(),getidentificationID(),getAddress()
                                            ,getDmy(),getGender(),getPostal(),getPhone()));
                gson.toJson(theList, write);
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            FileWriter write = new FileWriter(theFile);
            Gson gson = new Gson();
            theList = new ArrayList<>();
            theList.add(new Customer(getEmail(),getPassword(),getFirstName(),getLastName(),getidentificationID(),getAddress()
                                     ,getDmy(),getGender(),getPostal(),getPhone()));
            gson.toJson(theList, write);
            write.close();
        }
    }
    public void CustomerwithAccountJsonCreate() throws IOException{
        File theFile = new File("DataStorage/CustomerwithAccount.json");
        ArrayList<CustomerwithAccount> theCustomerwithAccountList;
        if(theFile.exists()){
            try (FileReader fileReader = new FileReader(theFile)) {
                Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
                Gson gson = new Gson();
                theCustomerwithAccountList = gson.fromJson(fileReader, type);
                fileReader.close();

                FileWriter write = new FileWriter(theFile);
                CustomerwithAccount cwa = new CustomerwithAccount();
                ArrayList<accountlist> alar = new ArrayList<>();
                
                cwa.setAccountlist(alar);
                theCustomerwithAccountList.add(new CustomerwithAccount(this.getEmail(),cwa.getAccountlist()));
                gson.toJson(theCustomerwithAccountList, write);
                write.close();
            } catch (JsonIOException e) {
                e.printStackTrace();
            }
        }else{
            FileWriter write = new FileWriter(theFile);
            theCustomerwithAccountList = new ArrayList<>(); 
    
            CustomerwithAccount cwa = new CustomerwithAccount();
            ArrayList<accountlist> alar = new ArrayList<>();
            
            cwa.setAccountlist(alar);
            theCustomerwithAccountList.add(new CustomerwithAccount(this.getEmail(),cwa.getAccountlist()));
            Gson gson = new Gson();
            gson.toJson(theCustomerwithAccountList, write);
            write.close();
        }
    }
    public void CreateAccount(String email) throws IOException {
        setEmail(email);
        Random random = new Random();
        int digits = random.nextInt(000000,999999);
        String randomed = String.format("%06d", digits);

        File theFile = new File("DataStorage/CustomerwithAccount.json");
        Gson gson = new Gson();

        //Read Data From CWA
        ArrayList<CustomerwithAccount> theCustomerwithAccountList = new ArrayList<>();

        FileReader fileReader = new FileReader(theFile);
        Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
        theCustomerwithAccountList = gson.fromJson(fileReader, type);
        fileReader.close();

        int i = 0;
        ArrayList<accountlist> alar = new ArrayList<>();
        for (CustomerwithAccount c : theCustomerwithAccountList) {
            if(c.getEmail().equals(getEmail())){
                for (accountlist a : c.getAccountlist()) {
                    alar.add(new accountlist(a.getAccount_no()));

                    while(a.getAccount_no().equals(randomed)){
                        random = new Random();
                        digits = random.nextInt(000000,999999);
                        randomed = String.format("%06d", digits);
                    }
                }
                alar.add(new accountlist(randomed));
                FileWriter write = new FileWriter(theFile);
                CustomerwithAccount cwa = new CustomerwithAccount();

                cwa.setAccountlist(alar);
                theCustomerwithAccountList.set(i,new CustomerwithAccount(this.getEmail(),cwa.getAccountlist()));
                gson.toJson(theCustomerwithAccountList, write);
                write.close();
            }
            i++;
        }
        CreateNewAccountFiles(randomed);
    }
    public void CreateNewAccountFiles(String accountNumber) throws IOException{
        File BookBankFile = new File("DataStorage/"+accountNumber+".json");

        FileWriter write = new FileWriter(BookBankFile);

        PersonalAccountData tac = new PersonalAccountData();
        tac.setAccount_no(accountNumber);
        tac.setBalance(0);
        tac.setAccount_type("SavingAccount");
        ArrayList<transaction> transaction = new ArrayList<>();
        transaction tran = new transaction();
        transaction.add(new transaction(tran.getStatement(), tran.getAmount()));
        tac.setTransaction(transaction);

        Gson writegson = new Gson();
        writegson.toJson(tac,write);
        write.close();
    }
    public void pullaccountnumber(){
        try {
            File theFile = new File("DataStorage/CustomerwithAccount.json");
            ArrayList<CustomerwithAccount> theCustomerwithAccountList = new ArrayList<>();

            FileReader fileReader = new FileReader(theFile);
            Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
            Gson gson = new Gson();
            theCustomerwithAccountList = gson.fromJson(fileReader, type);
            fileReader.close();

            ArrayList<String> account_no = new ArrayList<>();
            for (CustomerwithAccount c : theCustomerwithAccountList) {
                if(c.getEmail().equals(getEmail())){
                    for (accountlist a : c.getAccountlist()) {
                        account_no.add(a.getAccount_no());
                    }
                }
            }
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String registerallcheck(String email, String password, String fName, String lName, String id, String address, 
                                    String dmy, String gender, String postal, String phone){
        if(fName.equals("Enter Firstname") || fName.equals("")) 
            return "Please Fill in the firstname box!";
        if(lName.equals("Enter Lastname") || lName.equals("")) 
            return "Please Fill in the lastname box!";
        if(id.equals("Enter Identification ID") || id.equals("")) 
            return "Please Fill in the Identification ID box!";
        if(!idcheck(id)) 
            return "Please Fill the correct format of ID : 13 digits of number only!";
        if(address.equals("Enter Address") || address.equals("")) 
            return "Please Fill in the address box!";
        if(gender.equals("") || gender.equals("")) 
            return "Please choose the gender!";
        if(postal.equals("Enter Postal Code") || postal.equals("")) 
            return "Please Fill in the postal code box!";
        if(!postalcheck(postal)) 
            return "Please Fill the correct format of Postal Code : #####";
        if(phone.equals("Enter Phone Number") || phone.equals("")) 
            return "Please Fill in the phone number box!";
        if(!phonecheck(phone)) 
            return "Please Fill the correct format of Phone Number : 0##########";
        return "NICE";
    }
    public void getPersonalDataInFile() throws IOException{
        //#region getAccountNumber
		File theFile = new File("DataStorage/CustomerwithAccount.json");
        Gson gson = new Gson();

        //Read Data From CWA
        ArrayList<CustomerwithAccount> theCustomerwithAccountList = new ArrayList<>();

        FileReader fileReader = new FileReader(theFile);
        Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
        theCustomerwithAccountList = gson.fromJson(fileReader, type);
        fileReader.close();

        ArrayList<accountlist> alar = new ArrayList<>();
        for (CustomerwithAccount c : theCustomerwithAccountList) {
            if(c.getEmail().equals(getEmail())){
                for (accountlist a : c.getAccountlist()) {
                    alar.add(new accountlist(a.getAccount_no()));
                }
            }
        }
        //First Account Only
		String accountNumber = "";
        int i = 0;
		for (accountlist accountlist : alar) {
			accountNumber = accountlist.getAccount_no();
			if(i == 0)break;
            i++;
		}
		//#endregion
		try {
			FileReader AccountfileReader = new FileReader(new File("DataStorage/" + accountNumber + ".json"));
			PersonalAccountData pad = gson.fromJson(AccountfileReader, PersonalAccountData.class);
			
            pad.getAccount_no(); pad.getAccount_type(); pad.getBalance();

            for (transaction t : pad.getTransaction()) {
                t.getStatement();
                t.getAmount();
            }
		} catch (IOException e) {
			//
		}
    }
    public void deposit(String account_no,double amount) throws IOException {
        //#region getAccountNumber
		File theFile = new File("DataStorage/CustomerwithAccount.json");
        Gson gson = new Gson();

        //Read Data From CWA
        ArrayList<CustomerwithAccount> theCustomerwithAccountList = new ArrayList<>();

        FileReader fileReader = new FileReader(theFile);
        Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
        theCustomerwithAccountList = gson.fromJson(fileReader, type);
        fileReader.close();

        ArrayList<accountlist> alar = new ArrayList<>();
        for (CustomerwithAccount c : theCustomerwithAccountList) {
            if(c.getEmail().equals(getEmail())){
                for (accountlist a : c.getAccountlist()) {
                    alar.add(new accountlist(a.getAccount_no()));
                }
            }
        }
		//#endregion
		try {
			FileReader AccountfileReader = new FileReader(new File("DataStorage/" + account_no + ".json"));
			PersonalAccountData pad = gson.fromJson(AccountfileReader, PersonalAccountData.class);
            
            File BookBankFile = new File("DataStorage/"+account_no+".json");
            FileWriter write = new FileWriter(BookBankFile);

            PersonalAccountData tac = new PersonalAccountData();
            tac.setAccount_no(pad.getAccount_no());
            tac.setBalance(pad.getBalance()+amount);
            tac.setAccount_type(pad.getAccount_type());

            ArrayList<transaction> transaction = new ArrayList<>();

            for (transaction t : pad.getTransaction()) {
                transaction.add(new transaction(t.getStatement(),t.getAmount()));
            }
            transaction.add(new transaction("Deposit", amount));
            tac.setTransaction(transaction);

            Gson writegson = new Gson();
            writegson.toJson(tac,write);
            write.close();
		} catch (IOException e) {
			//
		}
    }
    public void withdraw(String account_no,double amount) throws IOException {
        //#region getAccountNumber
		File theFile = new File("DataStorage/CustomerwithAccount.json");
        Gson gson = new Gson();

        //Read Data From CWA
        ArrayList<CustomerwithAccount> theCustomerwithAccountList = new ArrayList<>();

        FileReader fileReader = new FileReader(theFile);
        Type type = new TypeToken<ArrayList<CustomerwithAccount>>(){}.getType();
        theCustomerwithAccountList = gson.fromJson(fileReader, type);
        fileReader.close();

        ArrayList<accountlist> alar = new ArrayList<>();
        for (CustomerwithAccount c : theCustomerwithAccountList) {
            if(c.getEmail().equals(getEmail())){
                for (accountlist a : c.getAccountlist()) {
                    alar.add(new accountlist(a.getAccount_no()));
                }
            }
        }
		//#endregion
		try {
			FileReader AccountfileReader = new FileReader(new File("DataStorage/" + account_no + ".json"));
			PersonalAccountData pad = gson.fromJson(AccountfileReader, PersonalAccountData.class);
            
            File BookBankFile = new File("DataStorage/"+account_no+".json");
            FileWriter write = new FileWriter(BookBankFile);

            PersonalAccountData tac = new PersonalAccountData();
            tac.setAccount_no(pad.getAccount_no());
            tac.setBalance(pad.getBalance()-amount);
            tac.setAccount_type(pad.getAccount_type());

            ArrayList<transaction> transaction = new ArrayList<>();
            
            for (transaction t : pad.getTransaction()) {
                transaction.add(new transaction(t.getStatement(),t.getAmount()));
            }
            transaction.add(new transaction("Withdraw", amount));
            tac.setTransaction(transaction);

            Gson writegson = new Gson();
            writegson.toJson(tac,write);
            write.close();
		} catch (IOException e) {
			//
		}
    }
}

