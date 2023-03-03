import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import BACKEND.Customer;

public class gsondemo {
    private static ArrayList<Customer> theList;
    public static void main(String[] args) {
		File theFile = new File("customers0.json");
        
        if(theFile.exists()){//read from file, print content
            try {
                FileReader read = new FileReader(theFile);
                Type type = new TypeToken<ArrayList<Customer>>(){}.getType();
                Gson gson = new Gson();
                theList = gson.fromJson(read, type);
                for(Customer p : theList){
                    System.out.println(p.getEmail());
                }
                read.close();
            } catch (IOException e) {
                e.toString();
            }
        }else{//create arraylist, write to the file
            theList = new ArrayList<>();
            theList.add(new Customer("@gmail","1"));
            theList.add(new Customer("hi@gmail","2"));
            theList.add(new Customer("hello@gmail","3"));


            try {
                FileWriter write = new FileWriter(theFile);
                Gson gson = new Gson();
                gson.toJson(theList, write);
                write.close();
            } catch (IOException e) {
                e.toString();
            }
        }
	}
}
