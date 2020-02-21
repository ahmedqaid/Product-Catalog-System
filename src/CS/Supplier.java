package CS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Supplier implements Serializable{

protected String name;
protected String id;
protected boolean status;
protected String address;
protected String number;

public void add(String name, boolean status, String number, String address)
{
    ArrayList<Supplier> deserialized = new ArrayList<Supplier>();
        
    try{
        FileInputStream filein = new FileInputStream("Suppliers.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Supplier>)in.readObject();
        in.close();
        filein.close();
        }
        catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
        
    this.name = name;
    this.status = true;
    this.number = number;
    this.address = address;
    UUID uniqueKey = UUID.randomUUID();
    this.id = uniqueKey.toString().substring(0,8);
    
        deserialized.add(this);
        
        try{
            FileOutputStream fileOut = new FileOutputStream("Suppliers.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deserialized);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            System.out.println("Error #1");
        }
          
}

public ArrayList ListSuppliers(){
            ArrayList<Supplier> deserialized = new ArrayList<Supplier>();
        
    try{
        FileInputStream filein = new FileInputStream("Suppliers.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Supplier>)in.readObject();
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

public void modify(String id){
    ArrayList<Supplier> deserialized = new ArrayList<Supplier>();
        
    try{
        FileInputStream filein = new FileInputStream("Suppliers.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Supplier>)in.readObject();
        in.close();
        filein.close();
        }
        catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
    
    Supplier[] supplierList = new Supplier[deserialized.size()];
    
    for (int i = 0; i < deserialized.size(); i++) {
        supplierList[i] = new Supplier();
        supplierList[i] = deserialized.get(i);
    }
    
    int x = 0;
    while(supplierList[x].id != id)
    {
        if(x >= deserialized.size()){
            System.out.println("Record doesn't exist.");
        }
        else if (supplierList[x].status == true && supplierList[x].id.equals(id)){
            supplierList[x].status = false;
            break;
        }
        else if(supplierList[x].status == false && supplierList[x].id.equals(id)){
         supplierList[x].status = true;
         break;
        }
        x++;
    }
    
    try{
            FileOutputStream fileOut = new FileOutputStream("Suppliers.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deserialized);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            System.out.println("Error #1");
        }
}

public String[] listNames(){
ArrayList<Supplier> deserialized = new ArrayList<Supplier>();
        
    try{
        FileInputStream filein = new FileInputStream("Suppliers.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Supplier>)in.readObject();
        in.close();
        filein.close();
        }
    catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
    
    Supplier[] supplierList = new Supplier[deserialized.size()];
    
    for (int i = 0; i < deserialized.size(); i++) {
        supplierList[i] = new Supplier();
        supplierList[i] = deserialized.get(i);
    }
    String[] OutputStringArray = new String[deserialized.size()];
    
    int x = 0;
    int y = 0;
    
    while(x < deserialized.size()){
        if(supplierList[x].status == true){
            OutputStringArray[x] = supplierList[x].name;
            y++;
        }
        x++;    
    }
    return OutputStringArray;
}

public String seeExtendedDetails(String id){
    ArrayList<Supplier> deserialized = new ArrayList<Supplier>();
        
    try{
        FileInputStream filein = new FileInputStream("Suppliers.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Supplier>)in.readObject();
        in.close();
        filein.close();
        }
    catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
    
    Supplier[] supplierList = new Supplier[deserialized.size()];
    
    for (int i = 0; i < deserialized.size(); i++) {
        supplierList[i] = new Supplier();
        supplierList[i] = deserialized.get(i);
    }
    
    int x = 0;
    while(supplierList[x].id != id){
        
        if(x >= deserialized.size()){
            System.out.println("Record doesn't exist.");
            break;
        }
        
        else if(supplierList[x].id.equals(id)){
            break;
        }
        x++;
    
}
    return String.format("Supplier name: %s\nSupplier ID: %s\nSupplier active: %b\nSupplier address: %s\nSupplier number: %s",supplierList[x].name, supplierList[x].id, supplierList[x].status, supplierList[x].address, supplierList[x].number);
}
public void delete(String id){
        ArrayList<Supplier> deserialized = new ArrayList<Supplier>();
        
    try{
        FileInputStream filein = new FileInputStream("Suppliers.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Supplier>)in.readObject();
        in.close();
        filein.close();
        }
        catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
    
    Supplier[] supplierList = new Supplier[deserialized.size()];
    
    for (int i = 0; i < deserialized.size(); i++) {
        supplierList[i] = new Supplier();
        supplierList[i] = deserialized.get(i);
    }
    
    int x = 0;
    while(supplierList[x].id != id){
        if(x >= deserialized.size()){
            System.out.println("Record doesn't exist.");
        }
        else{
            deserialized.remove(supplierList[x]);
            break;
        }
        x++;
    }
    
    try{
            FileOutputStream fileOut = new FileOutputStream("Suppliers.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deserialized);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            System.out.println("Error #1");
        }
}


public String toString(){
    return String.format("Supplier name: %s\nSupplier id: %d",name, id);
}

}


