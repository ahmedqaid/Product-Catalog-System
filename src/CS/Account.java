package CS;

import java.io.File;
import java.util.Scanner;

public class Account {
   String fileName;
    private static Scanner x;
    private boolean found = false;
        //The method below returns 1 if verification is successful, 0 if it is not.
    public int verifyLogin(String userName, String userPassword, String fileName){
    //This method/function checks the text file "AdminList" and
    //checks if what the user has entered matches the saved username/passwords.
        
        try{
           x = new Scanner(new File(fileName));
           String tempUsername = "";
           String tempPassword = "";
           x.useDelimiter("[,\n]");
           
           while(x.hasNext() && found == false)
           {
               tempUsername = x.next();
               tempPassword = x.next();
               
               if(tempUsername.trim().equals(userName.trim()) && tempPassword.trim().equals(userPassword.trim()))
                   found = true;
               else
                   found = false;
           }
           x.close();
        }
        catch(Exception e){
            System.out.println("Error finding file. Create a file in the program directory. Type 'root,toor'[no spaces] and save the file.");
        }
        
        if (found == true)
            return 1;
        else
            return 0;
        } 
    }