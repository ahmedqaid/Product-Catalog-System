package CS;

import java.util.UUID;

public class Catalog {
    private String referenceNumber;
    private String cTitle;
    private String cDescription;
    private String season;
    private String creator;
    private String dateCreated;
//    String[] items;
    

    
    public void setCatalog(String cTitle, String cDescription, String season, String creator) {
        UUID uniqueKey = UUID.randomUUID();
        this.referenceNumber = uniqueKey.toString().substring(0, 4);
        this.cTitle = cTitle;
        this.cDescription = cDescription;
        this.season = season;
        Time tim = new Time();
        this.dateCreated = tim.setDate();
        
    }

}