package CS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Time {
    Date date1 = new Date();
    
    public void LogTime(String username, String role) throws IOException{
        
        BufferedWriter out = new BufferedWriter(new FileWriter("LogOnOffTimes.txt", true));
        out.write(username + " logged on " + role + " " + date1.toString());
        out.newLine();
        out.close();
    }
    
    public void LogOffTime(String username, String role) throws IOException{
               
        BufferedWriter out = new BufferedWriter(new FileWriter("LogOnOffTimes.txt", true));
        out.write(username + " logged off " + role + " " + date1.toString());
        out.newLine();
        out.close();
    }
    
    public String setDate() {
        return date1.toString();
    }

    public static void main(String[] args) {
        Time t = new Time();
        System.out.println(t.setDate());
    }
}
