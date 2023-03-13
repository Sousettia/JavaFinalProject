package BACKEND;

import java.util.ArrayList;

public class FinanceNews {
    private ArrayList < DataFinanceNews > data = new ArrayList < DataFinanceNews > ();

    public ArrayList<DataFinanceNews> getData() {
        return data;
    }

    public void setData(ArrayList<DataFinanceNews> data) {
        this.data = data;
    }
}
