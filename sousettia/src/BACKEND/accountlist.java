package BACKEND;

public class accountlist {
    private String account_no;

    public accountlist(String account_no) {
        this.account_no = account_no;
    }

    public accountlist() {
        this.account_no = "null";
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }
}
