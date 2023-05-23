 
package com.mycompany.software_cons_develop_assign_no_3;
 // IssueBookFrame.javaj
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssueBookFrame extends JFrame {
    private JLabel bookIdLabel;
    private JLabel userIdLabel;
    private JLabel periodLabel;
    private JLabel issueDateLabel;
    private JTextField bookIdField;
    private JTextField userIdField;
    private JTextField periodField;
    private JTextField issueDateField;
    private JButton submitButton;

    public IssueBookFrame() {
        super("Issue Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        bookIdLabel = new JLabel("Book ID (BID):");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(bookIdLabel, gbc);

        bookIdField = new JTextField("int",20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(bookIdField, gbc);

        userIdLabel = new JLabel("User ID (UID):");
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(userIdLabel, gbc);

        userIdField = new JTextField("int",20);
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(userIdField, gbc);

        periodLabel = new JLabel("Period (days):");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(periodLabel, gbc);

        periodField = new JTextField("int",20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(periodField, gbc);

        issueDateLabel = new JLabel("Issue Date (DD-MM-YYYY):");
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(issueDateLabel, gbc);

        issueDateField = new JTextField("Str",20);
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(issueDateField, gbc);

        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement issue book functionality
                Issue issue=new Issue();
                issue.setBookId(Integer.parseInt(bookIdField.getText()));
                issue.setUserId(Integer.parseInt(userIdField.getText()));
                issue.setPeriod(Integer.parseInt(periodField.getText()));
                issue.setIssueDate(issueDateField.getText());
                IssueDAO issueDAO=new IssueDAO();
                 issueDAO.addIssue(issue);
                  JOptionPane.showMessageDialog(IssueBookFrame.this, "user Added Succesfully.");
            }
        });

        pack();
        setLocationRelativeTo(null);
    }
}

