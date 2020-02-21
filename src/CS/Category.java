package CS;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Category implements Serializable{

    String categoryId;
    String categoryName;
    String categoryDescription;
    
    public Category() {
          UUID uniqueKey = UUID.randomUUID();
          this.categoryId = uniqueKey.toString().substring(0, 8);
    }

    public void setNameDesc(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }
    
    public void add(String categoryName, String categoryDescription)
{
    ArrayList<Category> deserialized = new ArrayList<Category>();
        
    try{
        FileInputStream filein = new FileInputStream("Categories.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Category>)in.readObject();
        in.close();
        filein.close();
        }
        catch(IOException i){
           System.out.println("Error #2");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #3");
        }
        
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        
        deserialized.add(this);
        try{
            FileOutputStream fileOut = new FileOutputStream("Categories.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deserialized);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            System.out.println("Error #1");
        }
}

public ArrayList listCategories(){
            ArrayList<Category> deserialized = new ArrayList<Category>();
        
    try{
        FileInputStream filein = new FileInputStream("Categories.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Category>)in.readObject();
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

        public String[] listNames(){
ArrayList<Category> deserialized = new ArrayList<Category>();
        
    try{
        FileInputStream filein = new FileInputStream("Categories.txt");
        ObjectInputStream in = new ObjectInputStream(filein);
        deserialized = (ArrayList<Category>)in.readObject();
        in.close();
        filein.close();
        }
    catch(IOException i){
           System.out.println("Error #21");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error #31");
            
        }
    
    Category[] categoryList = new Category[deserialized.size()];
    
    for (int i = 0; i < deserialized.size(); i++) {
        categoryList[i] = new Category();
        categoryList[i] = deserialized.get(i);
    }
    String[] OutputStringArray = new String[deserialized.size()];
    
    int x = 0;
    while(x < deserialized.size()){
        OutputStringArray[x] = categoryList[x].categoryName;
        x++;    
    }
    return OutputStringArray;
}
        
}