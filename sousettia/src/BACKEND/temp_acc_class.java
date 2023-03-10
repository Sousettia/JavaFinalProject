package BACKEND;

import java.util.ArrayList;

public class temp_acc_class {
    private String account_no;
    private double balance;
    private String account_type;
    ArrayList < transaction > transaction;

    public temp_acc_class() {
        this.account_no = "null";
        this.balance = 0;
        this.account_type = "null";
        this.transaction = null;
    }

    public temp_acc_class(String account_no, double balance, String account_type,
            ArrayList<BACKEND.transaction> transaction) {
        this.account_no = account_no;
        this.balance = balance;
        this.account_type = account_type;
        this.transaction = transaction;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public ArrayList<transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(ArrayList<transaction> transaction) {
        this.transaction = transaction;
    }
}