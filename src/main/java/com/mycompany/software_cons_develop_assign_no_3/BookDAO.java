 
package com.mycompany.software_cons_develop_assign_no_3;
 // BookDAO.java (DAO)
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;
public class BookDAO {
     String username = "root";
    String password = "";
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Book")) {

            while (rs.next()) {
                Book book = new Book();
                book.setBID(rs.getString("BID"));
                book.setBNAME(rs.getString("BNAME"));
                 book.setGENRE(rs.getString("GENRE"));
                book.setPRICE(rs.getInt("PRICE"));
                // Set other book properties
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
public void addBook(Book book) {
    
    
    try {
        
    
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Book VALUES (?, ?,?,?)");
         
        stmt.setString(1, book.getBID());
        stmt.setString(2, book.getBNAME());
        stmt.setString(3, book.getGENRE());
        stmt.setInt(4, book.getPRICE());
        // Set other book properties to corresponding statement parameters

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }



    // Implement other methods like getBookById(), addBook(), updateBook(), deleteBook()
}
 
 
    
 
public void resetBooks() {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
         Statement stmt = conn.createStatement()) {
        // Truncate the books table to remove all records
        stmt.executeUpdate("TRUNCATE TABLE Book");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}