package CS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable{
    String itemID;
    String itemName;
    String brand;
    double price;
    String supplierName;
    String itemCategory;
    //String imageLocation;
    //String supplierName;
    
    public Product () {
        price = 0.0;
        //imageLocation = "C:\\Users\\q041\\OneDrive\\Documents\\NetBeansProjects\\Category\\src\\category\\default.png";
    }

    public void setAll (String itemID, String itemName, String brand, double price, String supplierName, String itemCategory) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.brand = brand;
        this.price = price;
        this.supplierName = supplierName;
        this.itemCategory = itemCategory;
    }
    
    
    
    public void addProduct(String itemID, String itemName, String brand, double price, String supplierName, String itemCategory)
{
    ArrayList<Product> deserialized = new ArrayList<Product>();
        
    try{
        FileInputStream filein = new FileInputStream("Products.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Product>)in.readObject();
        in.close();
        filein.close();
        }
        catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
    
        this.itemID = itemID;
        this.itemName = itemName;
        this.brand = brand;
        this.price = price;
        this.supplierName = supplierName;
        this.itemCategory = itemCategory;
        
        
        deserialized.add(this);
        
        try{
            FileOutputStream fileOut = new FileOutputStream("Products.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deserialized);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            System.out.println("Error #1");
        }
        
         
}

public ArrayList listProducts(){
            ArrayList<Product> deserialized = new ArrayList<Product>();
        
    try{
        FileInputStream filein = new FileInputStream("Products.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Product>)in.readObject();
        in.close();
        filein.close();
        }
        catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
    
    return deserialized;
        }
}