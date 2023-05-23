
package com.mycompany.software_cons_develop_assign_no_3;
// IssueDAO.java (DAO)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IssueDAO {
     public String username="root";
     public String password="";
     private Connection connection;
    public List<Issue> getAllIssuedBooks() {
        List<Issue> issuedBooks = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Issue")) {

            while (rs.next()) {
                Issue issue = new Issue();
                issue.setBookId(rs.getInt("bookid"));
                issue.setUserId(rs.getInt("userid"));
                issue.setPeriod(rs.getInt("period"));
                issue.setIssueDate(rs.getString("issueDate"));
                // Set other issue properties
                issuedBooks.add(issue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return issuedBooks;
    }

    // Implement other methods like issueBook(), returnBook()
    public void addIssue(Issue issue) {
    try {
        
    
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO issue VALUES (?, ?,?,?)");
         
        stmt.setInt(1, issue.getBookId());
        stmt.setInt(2, issue.getUserId());
        stmt.setInt(3, issue.getPeriod());
        stmt.setString(4, issue.getIssueDate());
        // Set other book properties to corresponding statement parameters

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

   
    }
    public void resetIssueBooks() {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
         Statement stmt = conn.createStatement()) {
        // Truncate the books table to remove all records
        stmt.executeUpdate("TRUNCATE TABLE issue");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}