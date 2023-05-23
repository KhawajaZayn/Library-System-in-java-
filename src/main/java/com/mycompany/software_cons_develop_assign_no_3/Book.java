 
package com.mycompany.software_cons_develop_assign_no_3;
 // Book.java (Model)
 

public class Book {
public  String BID,BNAME,GENRE;
public int PRICE;
    public void setBID(String BID) {
        this.BID = BID;
    }

    public void setBNAME(String BNAME) {
        this.BNAME = BNAME;
    }

    public void setGENRE(String GENRE) {
        this.GENRE = GENRE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    public String getBID() {
        return BID;
    }

    public String getBNAME() {
        return BNAME;
    }

    public String getGENRE() {
        return GENRE;
    }

    public int getPRICE() {
        return PRICE;
    }

  

    
}