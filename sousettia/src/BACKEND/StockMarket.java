package BACKEND;

import java.util.ArrayList;

public class StockMarket {
    ArrayList <DataStockMarket> data = new ArrayList<DataStockMarket>();

    public ArrayList<DataStockMarket> getData() {
        return data;
    }

    public void setData(ArrayList<DataStockMarket> data) {
        this.data = data;
    }
}
