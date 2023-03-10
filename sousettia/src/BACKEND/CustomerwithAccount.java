package BACKEND;

import java.util.ArrayList;

public class CustomerwithAccount {
    private String email;
    ArrayList<accountlist> accountlist;
    
    public CustomerwithAccount() {
        this.email = null;
        this.accountlist = null;
    }
    public CustomerwithAccount(String email, ArrayList<BACKEND.accountlist> accountlist) {
        this.email = email;
        this.accountlist = accountlist;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ArrayList<BACKEND.accountlist> getAccountlist() {
        return accountlist;
    }
    public void setAccountlist(ArrayList<accountlist> accountlist) {
        this.accountlist = accountlist;
    }
}
