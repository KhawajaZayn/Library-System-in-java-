 
package com.mycompany.software_cons_develop_assign_no_3;
 // AddUserFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserFrame extends JFrame {
     private JLabel UIDLabel;
    private JLabel USERNAMELabel;
      private JLabel PASSWORDLabel;
    private JLabel ADMINLabel;
    
    private JTextField UIDField;
    private JTextField USERNAMEField;
    private JTextField PASSWORDField;
    private JTextField ADMINField;
    private JButton AddButton;

    public AddUserFrame() {
        super("Add User");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        UIDLabel = new JLabel("UID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(UIDLabel, gbc);

        UIDField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(UIDField, gbc);

        USERNAMELabel = new JLabel("USERNAME:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(USERNAMELabel, gbc);

        USERNAMEField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(USERNAMEField, gbc);
        
         PASSWORDLabel = new JLabel("PASSWORD:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(PASSWORDLabel, gbc);

        PASSWORDField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(PASSWORDField, gbc);

        ADMINLabel = new JLabel("ADMIN:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(ADMINLabel, gbc);

        ADMINField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(ADMINField, gbc);
        AddButton = new JButton("ADD");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Set anchor to center
        add(AddButton, gbc);

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement add book functionality 
                //data is in text fields extract it and send it to database
                User user=new User();
                user.setUID(Integer.parseInt(UIDField.getText()));
                user.setUSERNAME(USERNAMEField.getText());
                 user.setPASSWORD(PASSWORDField.getText());
                user.setADMIN(Boolean.parseBoolean(ADMINField.getText()));
                UserDAO userDAO=new UserDAO();
                 userDAO.addUser(user);
                  JOptionPane.showMessageDialog(AddUserFrame.this, "user Added Succesfully.");
                 
                
                
            }
        });

        pack();
        setLocationRelativeTo(null);
    }
}
