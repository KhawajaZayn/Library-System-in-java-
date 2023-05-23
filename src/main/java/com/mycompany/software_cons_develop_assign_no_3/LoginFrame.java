 
package com.mycompany.software_cons_develop_assign_no_3;
// LoginFrame.java
import com.mycompany.software_cons_develop_assign_no_3.UserDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JLabel usernamelable;
    private JLabel passwordlable;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame()
    {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        usernamelable = new JLabel("USERNAME");
        passwordlable = new JLabel("PASSWORD");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() 
        { 
             
            public void actionPerformed(ActionEvent e)
           {            
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

               //UserDAO userDAO = new UserDAO();
               // User user = userDAO.authenticateUser(username, password);
                if (("admin".equals(username))&&("admin".equals(password)) )
                        {
//System.out.println(username+password);     this line is for testing purpose 
                    MainFrame mainFrame = new MainFrame();
                    setVisible(false);
                    mainFrame.setVisible(true);
                    dispose();
                } 
               
              /*   if ( user!=null) {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                    dispose();
                } */
                else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid credentials! Please try again.");
                }
                
            }
        });

        add(usernameField);
        add(passwordField);
        add(loginButton);

        pack();
        setLocationRelativeTo(null);
         
    }
    
   
}
