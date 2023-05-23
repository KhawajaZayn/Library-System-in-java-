 
package com.mycompany.software_cons_develop_assign_no_3;
 // User.java (Model)
 

public class User {
           
    public int UID;
    public String USERNAME;
    public String PASSWORD;
    public Boolean ADMIN;

    public User()
    {
        
    }
    public User(String USERNAME,String PASSWORD)
    {
        this.USERNAME=USERNAME;
        this.PASSWORD=PASSWORD;
        
    }
    public void setUID(int UID) {
        this.UID = UID;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setADMIN(Boolean ADMIN) {
        this.ADMIN= ADMIN;
    }

    public int getUID() {
        return UID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public Boolean getADMIN() {
        return ADMIN;
    }
   
    
    
    // Other user properties, getters, and setters
}