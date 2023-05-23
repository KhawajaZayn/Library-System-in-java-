 
package com.mycompany.software_cons_develop_assign_no_3;
 // AddBookFrame.java
 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookFrame extends JFrame {
    private JLabel BIDLabel;
    private JLabel BNAMELabel;
      private JLabel GENRELabel;
    private JLabel PRICELabel;
    
    private JTextField BIDField;
    private JTextField BNAMEField;
    private JTextField GENREField;
    private JTextField PRICEField;
    private JButton submitButton;

    public AddBookFrame() {
        super("Add Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        BIDLabel = new JLabel("BID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(BIDLabel, gbc);

        BIDField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(BIDField, gbc);

        BNAMELabel = new JLabel("BNAME:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(BNAMELabel, gbc);

        BNAMEField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(BNAMEField, gbc);
        
         GENRELabel = new JLabel("GENRE:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(GENRELabel, gbc);

        GENREField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(GENREField, gbc);

        PRICELabel = new JLabel("PRICE:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(PRICELabel, gbc);

        PRICEField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(PRICEField, gbc);
        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Set anchor to center
        add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement add book functionality 
                //data is in text fields extract it and send it to database
                Book book=new Book();
                book.setBID(BIDField.getText());
                book.setBNAME(BNAMEField.getText());
                 book.setGENRE(GENREField.getText());
                book.setPRICE(Integer.parseInt(PRICEField.getText()));
                 BookDAO bookDAO=new BookDAO();
                 bookDAO.addBook(book);//sending book to add in data base
                  JOptionPane.showMessageDialog(AddBookFrame.this, "Book Issued Succesfully.");
                 
                //IssueDAO issueDAO = new IssueDAO();
               // List<Issue> issuedBooks = issueDAO.getAllIssuedBooks();
                
            }
        });

        pack();
        setLocationRelativeTo(null);
    }
}