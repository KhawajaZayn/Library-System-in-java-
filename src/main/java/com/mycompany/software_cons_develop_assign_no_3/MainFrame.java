package com.mycompany.software_cons_develop_assign_no_3;
// MainFrame.java 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView;

public class MainFrame extends JFrame {
    private JButton viewBooksButton;
    private JButton viewUsersButton;
    private JButton viewIssuedBooksButton;
    private JButton issueBookButton;
    private JButton addUserButton;
    private JButton addBookButton;
    private JButton returnBookButton;
    private JButton resetButton;

    public MainFrame() {
        super("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        viewBooksButton = new JButton("View Books");
        viewUsersButton = new JButton("View Users");
        viewIssuedBooksButton = new JButton("View Issued Books");
        issueBookButton = new JButton("Issue Book");
        addUserButton = new JButton("Add User");
        addBookButton = new JButton("Add Book");
        returnBookButton = new JButton("Return Book");
        resetButton = new JButton("Reset");
        
    viewBooksButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.getAllBooks();
        
        // Create the table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("BID");
        model.addColumn("BNAME");
         model.addColumn("GENRE");
        model.addColumn("PRICE");
        model.setRowCount(0);
        for (Book book : books) {
            model.addRow(new Object[]{book.getBID(), book.getBNAME(),book.getGENRE(),book.getPRICE()});
        }

        // Create the table
        JTable bookTable = new JTable(model);
        
        // Create a scroll pane to contain the table
        JScrollPane scrollPane = new JScrollPane(bookTable);

        // Create a new frame for displaying the table
        JFrame frame = new JFrame();
        frame.setTitle("Books");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
});



        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDAO userDAO = new UserDAO();
                List<User> users = userDAO.getAllUsers();
                // Display users in a table
                    
        
        // Create the table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("UID");
        model.addColumn("USERNAME");
         model.addColumn("PASSWORD");
        model.addColumn("ADMIN");
        model.setRowCount(0);
        for (User user : users) {
            model.addRow(new Object[]{user.getUID(), user.getUSERNAME(),user.getPASSWORD(),user.getADMIN()});
        }

        // Create the table
        JTable bookTable = new JTable(model);
        
        // Create a scroll pane to contain the table
        JScrollPane scrollPane = new JScrollPane(bookTable);

        // Create a new frame for displaying the table
        JFrame frame = new JFrame();
        frame.setTitle("USERS");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
     
            }
        });

        viewIssuedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IssueDAO issueDAO = new IssueDAO();
                List<Issue> issuedBooks = issueDAO.getAllIssuedBooks();
                // Display issued books in a table
               
        // Create the table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("bookId");
        model.addColumn("userId");
         model.addColumn("period");
        model.addColumn("issueDate");
        model.setRowCount(0);
        for (Issue issue : issuedBooks) {
           model.addRow(new Object[]{issue.getBookId(), issue.getUserId(),issue.getPeriod(),issue.getIssueDate()});
        }

        // Create the table
        JTable bookTable = new JTable(model);
        
        // Create a scroll pane to contain the table
        JScrollPane scrollPane = new JScrollPane(bookTable);

        // Create a new frame for displaying the table
        JFrame frame = new JFrame();
        frame.setTitle("Issued Books");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
            }
        });

        issueBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IssueBookFrame issueBookFrame = new IssueBookFrame();
                issueBookFrame.setVisible(true);
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUserFrame addUserFrame = new AddUserFrame();
                addUserFrame.setVisible(true);
            }
        });

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookFrame addBookFrame = new AddBookFrame();
                addBookFrame.setVisible(true);
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement return book functionality
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement reset functionality
           
        BookDAO bookDAO = new BookDAO();
        UserDAO userDAO=new UserDAO();
        IssueDAO issueDAO=new IssueDAO();
   
        bookDAO.resetBooks(); // Reset the books table
        userDAO.resetUser(); //rest the users
        issueDAO.resetIssueBooks();//reset all the issued books 
        // Add similar reset logic for other tables if needed
  JOptionPane.showMessageDialog(MainFrame.this, "  DataBase Reset successfull ");

            }
        });

        add(viewBooksButton);
        add(viewUsersButton);
        add(viewIssuedBooksButton);
        add(issueBookButton);
        add(addUserButton);
        add(addBookButton);
        add(returnBookButton);
        add(resetButton);

        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        LoginFrame login =new LoginFrame();
         
         login.setVisible(true);
    }
}
