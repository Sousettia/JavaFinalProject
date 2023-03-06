package BACKEND;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataStorage.temp_acc_class;
import DataStorage.transaction;

public class transactionTest {
    public static void main(String[] args) throws IOException {
        File theFile = new File("DataStorage/allaccountlist.json");
        ArrayList<Customer> theList;
        FileReader fileReader = new FileReader(theFile);
            Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
            Gson gson = new Gson();
            theList = gson.fromJson(fileReader, type);
            fileReader.close();

            List<Integer> acc_list = new ArrayList<>();
            for(Customer c : theList){
                acc_list.add(c.getAccount_no());
            }   
        //-----------------------------------------------------------------
        String number_padded = String.format("%06d",Collections.max(acc_list)+1);
        File BookBankFile = new File("DataStorage/"+number_padded+".json");

        FileWriter write = new FileWriter(BookBankFile);

        temp_acc_class tac = new temp_acc_class();
        ArrayList<transaction> transaction = new ArrayList<>();
        transaction tran = new transaction();

        tac.setAccount_no(1);
        tac.setBalance(1000);
        tac.setAccount_type("SavingAccount");
        transaction.add(new transaction(tran.getStatement(), tran.getAmount()));
        tac.setTransaction(transaction);

        Gson writegson = new Gson();
        writegson.toJson(tac,write);
        write.close();
    }
}
