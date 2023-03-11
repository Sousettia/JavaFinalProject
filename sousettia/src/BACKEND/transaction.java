package BACKEND;

public class transaction {
    private String statement;
    private String destinationID;
    private double amount;
    
    public transaction(String statement) {
        this.statement = statement;
    }

    public transaction() {
        this.statement = "Open Account";
        this.amount = 0;
        this.destinationID = "";
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
    public String getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(String destinationID) {
        this.destinationID = destinationID;
    }
    public String toString(){
        return statement;
    }
}
