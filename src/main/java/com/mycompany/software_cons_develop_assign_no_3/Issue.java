 
package com.mycompany.software_cons_develop_assign_no_3;
 // Issue.java (Model)
 

import java.util.Date;

public class Issue {
   private int bookId;
    private int userId;
    private int period;
    private String issueDate;
    
    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public int getPeriod() {
        return period;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
 
    // Other issue properties, getters, and setters
}
