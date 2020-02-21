package CS;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Salman
 */
public class ProductManager extends User implements Serializable{

private String password;
    
public void add(String name, String password, String number, String address, String email)
{
    ArrayList<ProductManager> deserialized = new ArrayList<ProductManager>();
        
    try{
        //Writing the username and password to file.
    BufferedWriter out = new BufferedWriter(new FileWriter("PMusernamepass.txt", true));
    out.write(name + "," + password);
    out.newLine();
    out.close();
        
        FileInputStream filein = new FileInputStream("PMList.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<ProductManager>)in.readObject();
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
    this.number = number;
    this.address = address;
    UUID uniqueKey = UUID.randomUUID();
    this.id = uniqueKey.toString().substring(0,8);
    this.eMail = email;
    
        deserialized.add(this);
        
        try{
            FileOutputStream fileOut = new FileOutputStream("PMList.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deserialized);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            System.out.println("Error #1");
        }
}


//public void add(String name, String password, String number, String address, String email)
//{
//    ArrayList<ProductManager> deserialized = new ArrayList<ProductManager>();
//        
//    try{
//        //Writing the username and password to file.
//    BufferedWriter out = new BufferedWriter(new FileWriter("PMusernamepass.txt", true));
//    out.write(name + "," + password);
//    out.newLine();
//    out.close();
//        
//        FileInputStream filein = new FileInputStream("PMList.txt");
//        ObjectInputStream in = new ObjectInputStream(filein);
//        deserialized = (ArrayList<ProductManager>)in.readObject();
//        in.close();
//        filein.close();
//        }
//        catch(IOException i){
//           System.out.println("Error #2");
//        }
//        catch(ClassNotFoundException c){
//            System.out.println("Error #3");
//        }
//        
//    this.name = name;
//    this.number = number;
//    this.address = address;
//    UUID uniqueKey = UUID.randomUUID();
//    this.id = uniqueKey.toString().substring(0,8);
//    this.eMail = email;
//    
//        deserialized.add(this);
//        
//        try{
//            FileOutputStream fileOut = new FileOutputStream("PMList.txt");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(deserialized);
//            out.close();
//            fileOut.close();
//        }
//        catch(IOException i){
//            System.out.println("Error #1");
//        }
//}

    
public void modifyDetails(String id, String number, String email, String address){
    ArrayList<ProductManager> deserialized = new ArrayList<ProductManager>();
        
    try{
        FileInputStream filein = new FileInputStream("PMList.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<ProductManager>)in.readObject();
        in.close();
        filein.close();
        }
    catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
    
    ProductManager[] ManagerList = new ProductManager[deserialized.size()];
    
    for (int i = 0; i < deserialized.size(); i++) {
        ManagerList[i] = new ProductManager();
        ManagerList[i] = deserialized.get(i);
    }
    
    int x = 0;
    while(ManagerList[x].id != id){
        
        if(x >= deserialized.size()){
            System.out.println("Record doesn't exist.");
            break;
        }
        
        else if(ManagerList[x].id.equals(id)){
            
            break;
        }
        x++;
    
}
    
    this.number = number;
    this.address = address;
    this.eMail = email;
    
    deserialized.set(x, this);
    

 try{
            FileOutputStream fileOut = new FileOutputStream("PMList.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deserialized);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            System.out.println("Error #1");
        }
}
public String seeExtendedDetails(String id){
    ArrayList<ProductManager> deserialized = new ArrayList<ProductManager>();
        
    try{
        FileInputStream filein = new FileInputStream("PMList.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<ProductManager>)in.readObject();
        in.close();
        filein.close();
        }
    catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
    
    ProductManager[] ManagerList = new ProductManager[deserialized.size()];
    
    for (int i = 0; i < deserialized.size(); i++) {
        ManagerList[i] = new ProductManager();
        ManagerList[i] = deserialized.get(i);
    }
    
    int x = 0;
    while(ManagerList[x].id != id){
        
        if(x >= deserialized.size()){
            System.out.println("Record doesn't exist.");
            break;
        }
        
        else if(ManagerList[x].id.equals(id)){
            break;
        }
        x++;
    
}
    return String.format("Manager name: %s\nManager ID: %s\nManager address: %s\nManager number: %s\nManager email: %s",ManagerList[x].name, ManagerList[x].id, ManagerList[x].address, ManagerList[x].number, ManagerList[x].eMail);
}

public void delete(String id){
        ArrayList<ProductManager> deserialized = new ArrayList<ProductManager>();
        
    try{
        FileInputStream filein = new FileInputStream("PMList.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<ProductManager>)in.readObject();
        in.close();
        filein.close();
        }
        catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
    
    ProductManager[] ManagerList = new ProductManager[deserialized.size()];
    
    for (int i = 0; i < deserialized.size(); i++) {
        ManagerList[i] = new ProductManager();
        ManagerList[i] = deserialized.get(i);
    }
    
    int x = 0;
    while(ManagerList[x].id != id){
        if(x >= deserialized.size()){
            System.out.println("Record doesn't exist.");
        }
        else{
            deserialized.remove(ManagerList[x]);
            break;
        }
        x++;
    }
    
    try{
            FileOutputStream fileOut = new FileOutputStream("PMList.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deserialized);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            System.out.println("Error #1");
        }
}
    
}
