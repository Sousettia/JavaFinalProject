package BACKEND;

public class SavingAccount implements Interface_Account{
    private int accountNumber;
    private double balance;
    private double interestrate;

    public SavingAccount(){
        interestrate = 0.1;
        balance = 1000;
        accountNumber = 1;
    }

    //#region getter_setter

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    //#endregion 

    public boolean transfer(String Destination_accountNumber,double amount) {
        return true;
    }


    @Override
    public boolean deposit(double amount) {
        this.balance = this.balance + amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if(this.balance < amount) {
            return false;
        }
        else {
            this.balance = this.balance - amount;
            return true;
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void CreatedAccount(String identificationID, String accountType) {
        
    }
}

