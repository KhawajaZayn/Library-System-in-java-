 
package com.mycompany.software_cons_develop_assign_no_3;
// UserDAO.java (DAO)
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
     public String username="root";
     public String password="";
      private Connection connection;
    UserDAO() {
        
    }
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM user")) {

            while (rs.next()) {
                User user = new User();
                user.setUID(rs.getInt("UID"));
                user.setUSERNAME(rs.getString("USERNAME"));
                  user.setPASSWORD(rs.getString("PASSWORD"));
                user.setADMIN(rs.getBoolean("ADMIN"));
                // Set other user properties
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void addUser(User user) {
    
    
    try {
        
    
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO user VALUES (?, ?,?,?)");
         
        stmt.setInt(1, user.getUID());
        stmt.setString(2, user.getUSERNAME());
        stmt.setString(3, user.getPASSWORD());
        stmt.setBoolean(4, user.getADMIN());
        // Set other book properties to corresponding statement parameters

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

   
    }
     
public UserDAO(Connection connection) {
        this.connection = connection;
    }
   /*public User authenticateUser(String username, String password) {
        User user = null;
        
       String query = "SELECT * FROM User WHERE username = ? AND password = ?";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
            PreparedStatement statement = conn.prepareStatement(query);
            //(PreparedStatement statement = connection.prepareStatement(query)) 
            statement.setString(1,username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                 
                String USERNAME = resultSet.getString("USERNAME");
                String PASSWORD = resultSet.getString("PASSWORD");
                user = new User(USERNAME,PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }*/

    
    public void resetUser() {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", username, password);
         Statement stmt = conn.createStatement()) {
        // Truncate the books table to remove all records
        stmt.executeUpdate("TRUNCATE TABLE user");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}

