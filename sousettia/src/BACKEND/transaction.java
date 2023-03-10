package BACKEND;

public class transaction {
    private String statement;
    private double amount;
    
    public transaction() {
        this.statement = "Open Account";
        this.amount = 0;
    }
    public transaction(String statement, double amount) {
        this.statement = statement;
        this.amount = amount;
    }
    public String getStatement() {
        return statement;
    }
    public void setStatement(String statement) {
        this.statement = statement;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
