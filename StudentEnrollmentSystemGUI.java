package App_project;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class StudentEnrollmentSystemGUI {   
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/projects";
    private static final String JDBC_USERNAME = "luvish";
    private static final String JDBC_PASSWORD = "123456";
    private static Connection connection;
    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            createAndShowGUI();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Student Enrollment System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(550, 650);
    frame.setResizable(false);

    // Create a main panel with a light blue background
    JPanel mainPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(173, 216, 230)); // Light blue background color
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    // Create a label for the text "Student Semester Enrollment"
    JLabel titleLabel = new JLabel("<html><u>Student Semester Enrollment</u></html>");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    // Create a logo panel with a light background
    JPanel logoPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
             // Light gray background color
            int x = (getWidth() - 400) / 2; // Center horizontally
            int y = (getHeight() - 200) / 2; // Center vertically
            g.fillRect(x, y, 400, 200);
            try {
                BufferedImage logoImage = ImageIO.read(new File("C:\\Users\\LENOVO\\Desktop\\srm logo(4).png"));
                int width = 480;
                int height = (int) (logoImage.getHeight() / (float) logoImage.getWidth() * width); // Maintain aspect ratio
                int imgX = x + (400 - width) / 2; // Center the image horizontally
                int imgY = y + (200 - height) / 2; // Center the image vertically
                g.setColor(Color.BLACK);
                g.drawImage(logoImage, imgX, imgY, width, height, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    // Create a button panel with a transparent background
    JPanel buttonPanel = new JPanel();
    buttonPanel.setOpaque(false);
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

    // Style the buttons with a transparent background and larger size
    JButton teacherButton = new JButton("Teacher");
    JButton studentButton = new JButton("Student");
    JButton exitButton = new JButton("Exit");
    teacherButton.setFont(new Font("Arial", Font.PLAIN, 18));
    studentButton.setFont(new Font("Arial", Font.PLAIN, 18));
    exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
    teacherButton.setOpaque(false);
    studentButton.setOpaque(false);
    exitButton.setOpaque(false);

    // Increase the button size
    Dimension buttonSize = new Dimension(200, 60);
    teacherButton.setSize(buttonSize);
    studentButton.setSize(buttonSize);
    exitButton.setSize(buttonSize);
    mainPanel.setLayout(new GridLayout(3, 1)); // Set layout manager to null for manual positioning
    mainPanel.add(logoPanel);
    mainPanel.add(titleLabel);
    //int top = 60;
    //int left = 20;
    //int bottom = 10;
    //int right = 20;
    //teacherButton.setBorder(new EmptyBorder(top,left,bottom,right));
    //studentButton.setBorder(new EmptyBorder(top,left,bottom,right));
    //exitButton.setBorder(new EmptyBorder(top,left,bottom,right));
    teacherButton.setVerticalTextPosition(AbstractButton.CENTER);
            teacherButton.setHorizontalTextPosition(AbstractButton.CENTER);
            studentButton.setVerticalTextPosition(AbstractButton.CENTER);
            studentButton.setHorizontalTextPosition(AbstractButton.CENTER);
            exitButton.setVerticalTextPosition(AbstractButton.CENTER);
            exitButton.setHorizontalTextPosition(AbstractButton.CENTER);
    buttonPanel.add(teacherButton);
    buttonPanel.add(studentButton);
    buttonPanel.add(exitButton);
    mainPanel.add(buttonPanel);

    // Add the main panel to the frame
    frame.add(mainPanel);
    
    // Add buttons to the button panel
    
    

    // Manually position the button panel
    buttonPanel.setBounds(300, 400, 200, 60);

    // Add components to the main panel
    

    frame.setVisible(true);
    
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               handleTeacherLogin();
            }
        });

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleStudentMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);}
    private static void handleTeacherLogin(){
        JFrame jFrame=new JFrame("Login");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(550, 650);
        jFrame.setLayout(new GridLayout(3,1));
        JPanel logoPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
             // Light gray background color
            int x = (getWidth() - 400) / 2; // Center horizontally
            int y = (getHeight() - 200) / 2; // Center vertically
            g.fillRect(x, y, 400, 200);
            try {
                BufferedImage logoImage = ImageIO.read(new File("C:\\Users\\LENOVO\\Desktop\\srm logo(4).png"));
                int width = 480;
                int height = (int) (logoImage.getHeight() / (float) logoImage.getWidth() * width); // Maintain aspect ratio
                int imgX = x + (400 - width) / 2; // Center the image horizontally
                int imgY = y + (200 - height) / 2; // Center the image vertically
                g.setColor(Color.BLACK);
                g.drawImage(logoImage, imgX, imgY, width, height, this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
        JTextField teacherid=new JTextField(20);
        teacherid.setPreferredSize(new Dimension(200, 20));
        teacherid.setBounds(0, 0, 200, 30);
        //addHint(teacherid,"Enter the id here");
        JTextField password=new JTextField(20);
        JLabel textLogin=new JLabel("Enter Log in ID");
        JLabel textPassword=new JLabel("Enter password here");
        password.setPreferredSize(new Dimension(200, 90));
        //addHint(teacherid,"Enter password here");
        JButton submit=new JButton("Submit");
        JButton backButton = new JButton("Back");
        JLabel messageLabel = new JLabel("Log-in Page");
        //JPanel panel=new JPanel(new GridLayout(2,2));
        JPanel panel = new JPanel(new GridLayout(2,2)) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(173, 216, 230)); // Light blue background color
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
        //JPanel p2=new JPanel(new GridLayout(2,1));
        JPanel p2 = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(173, 216, 230)); // Light blue background color
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
        //JPanel p3=new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel p3 = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(173, 216, 230)); // Light blue background color
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
        
        p3.add(backButton);
        p3.add(submit);
         
        p2.add(messageLabel);
        
        panel.add(textLogin);
        panel.add(teacherid);
        panel.add(textPassword);
        panel.add(password);
        p2.add(panel);
        submit.setHorizontalAlignment(AbstractButton.CENTER);
        submit.setVerticalTextPosition(AbstractButton.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        
        jFrame.add(logoPanel);
        jFrame.add(p2);
        jFrame.add(p3);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String id=teacherid.getText();
                String pass=password.getText();
                if(checkIdAndPassword(id, pass))
                {
                    handleTeacherMenu();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong id and password", "Information", JOptionPane.INFORMATION_MESSAGE);
                    teacherid.setText("");
                    password.setText("");
                }
                
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                createAndShowGUI();
            }
            
        });
        jFrame.setVisible(true);

    }
    private static boolean checkIdAndPassword(String id, String password){
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            String query = "SELECT * FROM login WHERE ID = ? AND Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void handleTeacherMenu() {
        JFrame teacherFrame = new JFrame("Teacher Menu");
teacherFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
teacherFrame.setSize(550, 650);
teacherFrame.setResizable(false);


// Create a main panel with a light blue background
JPanel mainPanel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(173, 216, 230)); // Light blue background color
        g.fillRect(0, 0, getWidth(), getHeight());
    }
};

// Create a label for the text "Teacher Menu"
JLabel titleLabel = new JLabel("<html><u>Teacher Menu</u></html>");
titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
titleLabel.setHorizontalAlignment(JLabel.CENTER);

// Create a logo panel
JPanel logoPanel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(192, 192, 192)); // Light gray background color

        int x = (getWidth() - 400) / 2; // Center horizontally
        int y = (getHeight() - 200) / 2; // Center vertically
        g.fillRect(x, y, 400, 200);

        try {
            BufferedImage logoImage = ImageIO.read(new File("C:\\Users\\LENOVO\\Desktop\\srm logo(4).png"));
            int width = 480; // Adjust the width as needed
            int height = (int) (logoImage.getHeight() / (float) logoImage.getWidth() * width); // Maintain aspect ratio
            int imgX = x + (400 - width) / 2; // Center the image horizontally
            int imgY = y + (200 - height) / 2; // Center the image vertically
            g.setColor(Color.BLACK);
            g.drawImage(logoImage, imgX, imgY, width, height, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
};

// Create a button panel with a transparent background
JPanel buttonPanel = new JPanel();
buttonPanel.setOpaque(false);
buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

// Style the buttons with a transparent background and larger size
JButton viewAllDetailsButton = new JButton("View all student details");
JButton viewParticularDetailButton = new JButton("View particular student detail");
JButton displayTableButton = new JButton("Display teacher table");
JButton approveStudentButton = new JButton("Approve a student");
JButton backButton = new JButton("Back");
viewAllDetailsButton.setFont(new Font("Arial", Font.PLAIN, 15));
viewParticularDetailButton.setFont(new Font("Arial", Font.PLAIN, 15));
displayTableButton.setFont(new Font("Arial", Font.PLAIN, 15));
approveStudentButton.setFont(new Font("Arial", Font.PLAIN, 15));
backButton.setFont(new Font("Arial", Font.PLAIN, 15));
viewAllDetailsButton.setOpaque(false);
viewParticularDetailButton.setOpaque(false);
displayTableButton.setOpaque(false);
approveStudentButton.setOpaque(false);
backButton.setOpaque(false);

// Increase the button size
Dimension buttonSize = new Dimension(200, 60);
viewAllDetailsButton.setPreferredSize(buttonSize);
viewParticularDetailButton.setPreferredSize(buttonSize);
displayTableButton.setPreferredSize(buttonSize);
approveStudentButton.setPreferredSize(buttonSize);
backButton.setPreferredSize(buttonSize);

mainPanel.setLayout(new GridLayout(3, 1)); // Set layout manager to null for manual positioning
mainPanel.add(logoPanel);
mainPanel.add(titleLabel);

// Add buttons to the button panel
buttonPanel.add(viewAllDetailsButton);
buttonPanel.add(viewParticularDetailButton);
buttonPanel.add(displayTableButton);
buttonPanel.add(approveStudentButton);
buttonPanel.add(backButton);

mainPanel.add(buttonPanel);

// Add the main panel to the frame
teacherFrame.add(mainPanel);

teacherFrame.setVisible(true);

        viewAllDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllStudentDetails();
            }
        });

        viewParticularDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Student Details");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(800, 500);
                //frame.setBackground(Color.getHSBColor(173,216,230));
                JPanel mainPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(173, 216, 230)); // Light blue background color
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
                    
        
                String reg_no = JOptionPane.showInputDialog(frame, "Registeration no.:");
                if (reg_no != null) {  // User clicked OK
                    try {
                        String query = "SELECT * FROM student WHERE reg_no = '" + reg_no + "'";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);
        
                        DefaultTableModel model = new DefaultTableModel();
                        JTable table = new JTable(model);
                        JScrollPane scrollPane = new JScrollPane(table);
                        
                        model.addColumn("Sl.no");
                        model.addColumn("Date of Birth");
                        model.addColumn("Phone number");
                        model.addColumn("Semester");
                        model.addColumn("Department");
                        model.addColumn("Aadhaar number");
                        model.addColumn("ABC ID");
                        model.addColumn("Gender");
                        model.addColumn("Father name");
                        model.addColumn("Father phone number");
                        model.addColumn("Attendance");
                        model.addColumn("Address");
                        model.addColumn("CGPA");
                        model.addColumn("Approval");
                        model.addColumn("reg_no");
                        model.addColumn("student_name");
                        
                        while (resultSet.next()) {
                            model.addRow(new Object[] {
                                resultSet.getString("DOB"),
                                resultSet.getString("Phone_no"),
                                resultSet.getString("Semester"),
                                resultSet.getString("Department"),
                                resultSet.getString("Aadhar_No"),
                                resultSet.getString("ABC_ID"),
                                resultSet.getString("Gender"),
                                resultSet.getString("Father_Name"),
                                resultSet.getString("Father_number"),
                                resultSet.getString("Attendence_of_last_Sem"),
                                resultSet.getString("Address_day_scholar"),
                                resultSet.getString("CGPA_of_last_Sem"),
                                resultSet.getString("Approve"),
                                resultSet.getString("reg_no"),
                                resultSet.getString("student_name")
                            });
                        }
                        
                        scrollPane.setBackground(Color.blue);
                        frame.add(scrollPane);
                        JButton backButton = new JButton("Back to Teacher's Menu");
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Close the current frame
                    }
                });

                JPanel buttonPanel = new JPanel();
                buttonPanel.add(backButton);

                frame.add(buttonPanel, BorderLayout.SOUTH); // Add the "Back" button to the bottom

                frame.setVisible(true);

        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        displayTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    JFrame frame = new JFrame("Teacher Table");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(800, 500);
            
                    try {
                        // Replace with the correct table name
                        String tableName = "teacher"; 
            
                        String query = "SELECT * FROM " + tableName;
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);
            
                        DefaultTableModel model = new DefaultTableModel();
                        JTable table = new JTable(model);
                        JScrollPane scrollPane = new JScrollPane(table);
            
                        // Add columns to the table model
                        model.addColumn("Sno.");
                        model.addColumn("Registration Number");
                        model.addColumn("Student Name");
                        model.addColumn("Branch");
                        model.addColumn("Enrollment Status");
                        model.addColumn("Approval");
            
                        while (resultSet.next()) {
                            model.addRow(new Object[] {
                                resultSet.getInt("Sno"),
                                resultSet.getString("reg_no"),
                                resultSet.getString("Student_name"),
                                resultSet.getString("branch"),
                                resultSet.getString("enrollment_status"),
                                resultSet.getString("Approve")
                            });
                        }
            
                        frame.add(scrollPane);
                        JButton backButton = new JButton("Back to Teacher's Menu");
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Close the current frame
                    }
                });

                JPanel buttonPanel = new JPanel();
                buttonPanel.add(backButton);

                frame.add(buttonPanel, BorderLayout.SOUTH); // Add the "Back" button to the bottom

                frame.setVisible(true);

            
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            
        });

        approveStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Approve Students");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(550, 650);
                
                try {
                    String teacherTableName = "teacher"; // Replace with the correct teacher table name
                    String studentTableName = "student"; // Replace with the correct student table name
        
                    String query = "SELECT reg_no FROM " + teacherTableName;
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
        
                    DefaultTableModel model = new DefaultTableModel();
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
        
                    model.addColumn("Registration Number");
                    model.addColumn("Approve");
        
                    while (resultSet.next()) {
                        String regNumber = resultSet.getString("reg_no");
                        JButton approveButton = new JButton("Approve");
                        approveButton.setSize(100,30);
                        
                        approveButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Debug message to see if the button is clicked
                                //System.out.println("Button clicked for registration number: " + regNumber);
        
                                try {
                                    // Update the teacher table
                                    String teacherUpdateQuery = "UPDATE " + teacherTableName + " SET Approve = 'Yes' WHERE reg_no = '" + regNumber + "'";
                                    statement.executeUpdate(teacherUpdateQuery);
        
                                    // Update the student table
                                    String studentUpdateQuery = "UPDATE " + studentTableName + " SET Approve = 'Yes' WHERE reg_no = '" + regNumber + "'";
                                    statement.executeUpdate(studentUpdateQuery);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
        
                        model.addRow(new Object[] { regNumber, approveButton });
                    }
        
                    JButton backButton = new JButton("Back to teacher's menu");
                    backButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.dispose(); // Close the current frame
                        }
                    });
        
                    JPanel buttonPanel = new JPanel();
                    buttonPanel.add(backButton);
        
                    frame.add(scrollPane);
                    frame.add(buttonPanel, BorderLayout.SOUTH);
                    frame.pack();
                    frame.setVisible(true);
                    approveStudentButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame frame = new JFrame("Approve Students");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.setSize(550, 650);
                    
                            try {
                                String teacherTableName = "teacher"; // Replace with the correct teacher table name
                                String studentTableName = "student"; // Replace with the correct student table name
                    
                                String query = "SELECT reg_no FROM " + teacherTableName;
                                Statement statement = connection.createStatement();
                                ResultSet resultSet = statement.executeQuery(query);
                    
                                DefaultTableModel model = new DefaultTableModel();
                                JTable table = new JTable(model);
                                JScrollPane scrollPane = new JScrollPane(table);
                    
                                model.addColumn("Registration Number");
                                model.addColumn("Approve");
                    
                                while (resultSet.next()) {
                                    String regNumber = resultSet.getString("reg_no");
                                    JButton approveButton = new JButton("Approve");
                                    approveButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Debug message to see if the button is clicked
                                            System.out.println("Button clicked for registration number: " + regNumber);
                    
                                            try {
                                                // Update the teacher table
                                                String teacherUpdateQuery = "UPDATE " + teacherTableName + " SET Approve = 'Yes' WHERE reg_no = '" + regNumber + "'";
                                                statement.executeUpdate(teacherUpdateQuery);
                    
                                                // Update the student table
                                                String studentUpdateQuery = "UPDATE " + studentTableName + " SET Approve = 'Yes' WHERE ABC_ID = '" + regNumber + "'";
                                                statement.executeUpdate(studentUpdateQuery);
                                            } catch (SQLException ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    });
                    
                                    model.addRow(new Object[] { regNumber, approveButton });
                                }
                    
                                JButton backButton = new JButton("Back");
                                backButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame.dispose(); // Close the current frame
                                    }
                                });
                    
                                JPanel buttonPanel = new JPanel();
                                buttonPanel.add(backButton);
                    
                                frame.add(scrollPane);
                                frame.add(buttonPanel, BorderLayout.SOUTH);
                                frame.setVisible(true);
                    
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(frame, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherFrame.dispose(); // Close the teacher menu
            }
        });

        teacherFrame.setVisible(true);
    }
    
    private static void handleStudentMenu() {
        JFrame studentFrame = new JFrame("Student Menu");
        studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        studentFrame.setSize(550, 650);
        studentFrame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(173, 216, 230)); // Light blue background color
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        JPanel logoPanel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(192, 192, 192)); // Light gray background color

        int x = (getWidth() - 400) / 2; // Center horizontally
        int y = (getHeight() - 200) / 2; // Center vertically
        g.fillRect(x, y, 400, 200);

        try {
            BufferedImage logoImage = ImageIO.read(new File("C:\\Users\\LENOVO\\Desktop\\srm logo(4).png"));
            int width = 480; // Adjust the width as needed
            int height = (int) (logoImage.getHeight() / (float) logoImage.getWidth() * width); // Maintain aspect ratio
            int imgX = x + (400 - width) / 2; // Center the image horizontally
            int imgY = y + (200 - height) / 2; // Center the image vertically
            g.setColor(Color.BLACK);
            g.drawImage(logoImage, imgX, imgY, width, height, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
};

        JLabel titleLabel = new JLabel("<html><u>Student Menu</u></html>");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton insertDetailsButton = new JButton("Insert Student Details");
        JButton checkStatusButton = new JButton("Check Approval Status");
        JButton backButton = new JButton("Back");

        // Adjust button text size
        insertDetailsButton.setFont(new Font("Arial", Font.PLAIN, 15));
        checkStatusButton.setFont(new Font("Arial", Font.PLAIN, 15));
        backButton.setFont(new Font("Arial", Font.PLAIN, 15));

        insertDetailsButton.setOpaque(false);
        checkStatusButton.setOpaque(false);
        backButton.setOpaque(false);

        Dimension buttonSize = new Dimension(200, 60);
        insertDetailsButton.setPreferredSize(buttonSize);
        checkStatusButton.setPreferredSize(buttonSize);
        backButton.setPreferredSize(buttonSize);

        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.add(logoPanel);
        mainPanel.add(titleLabel);
       

        buttonPanel.add(insertDetailsButton);
        buttonPanel.add(checkStatusButton);
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel);

        studentFrame.add(mainPanel);

        studentFrame.setVisible(true);

        insertDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentform();
            }
        });
        
        checkStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Student Approval Status");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(550, 650);
        
                JPanel mainPanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(new Color(173, 216, 230)); // Light blue background color
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
        
                try {
                    // Connect to your database (ensure you have a valid connection)
        
                    // Create a statement to retrieve registration numbers and approval statuses
                    String query = "SELECT reg_no, Approve FROM student";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
        
                    // Create a table to display the results
                    DefaultTableModel model = new DefaultTableModel();
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
        
                    model.addColumn("Registration Number");
                    model.addColumn("Approval Status");
        
                    // Add data to the table
                    while (resultSet.next()) {
                        String regNumber = resultSet.getString("reg_no");
                        String approvalStatus = resultSet.getString("Approve");
                        model.addRow(new Object[] { regNumber, approvalStatus });
                    }
        
                    frame.add(scrollPane);
        
                    // Add a Back button
                    JButton backButton = new JButton("Back to student menu");
                    backButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.dispose(); // Close the current window
                        }
                    });
        
                    frame.add(backButton, BorderLayout.SOUTH);
        
                    frame.setVisible(true);
        
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentFrame.dispose(); // Close the student menu
            }
        });

        studentFrame.setVisible(true);
         }
    private static void displayAllStudentDetails() {
        JFrame frame = new JFrame("Student Form");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(550, 650);

        try {
            String query = "SELECT * FROM student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            DefaultTableModel model = new DefaultTableModel();
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            model.addColumn("Sl.no");
            model.addColumn("Date of Birth");
            model.addColumn("Phone number");
            model.addColumn("Semester");
            model.addColumn("Department");
            model.addColumn("Aadhaar number");
            model.addColumn("ABC ID");
            model.addColumn("Gender");
            model.addColumn("Father name");
            model.addColumn("Father phone number");
            model.addColumn("Attendance");
            model.addColumn("Address");
            model.addColumn("CGPA");
            model.addColumn("Approval");
            model.addColumn("reg_no");
            model.addColumn("student_name");

            int slNo = 1;
            while (resultSet.next()) {
                model.addRow(new Object[]{
                        slNo++,
                        resultSet.getString("DOB"),
                        resultSet.getString("Phone_no"),
                        resultSet.getString("Semester"),
                        resultSet.getString("Department"),
                        resultSet.getString("Aadhar_No"),
                        resultSet.getString("ABC_ID"),
                        resultSet.getString("Gender"),
                        resultSet.getString("Father_Name"),
                        resultSet.getString("Father_number"),
                        resultSet.getString("Attendence_of_last_Sem"),
                        resultSet.getString("Address_day_scholar"),
                        resultSet.getString("CGPA_of_last_Sem"),
                        resultSet.getString("Approve"),
                        resultSet.getString("reg_no"),
                        resultSet.getString("student_name")
                });
            }

            JButton backButton = new JButton("Back to Teacher Menu");
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Add code to go back to the teacher screen here
                    frame.dispose(); // Close the student screen
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(backButton);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void studentform(){
        
                JFrame frame=new JFrame("Student Form");
                 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(550, 650);
                JPanel mainPanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(new Color(173, 216, 230)); // Light blue background color
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
                frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
                JLabel dob = new JLabel("Enter DOB(YYYY-MM-DD)");
                JLabel phoneno = new JLabel("Enter Phone number");
                JLabel semester = new JLabel("Enter Semester");
                JLabel department = new JLabel("Enter department");
                //JLabel messageLabel = new JLabel("Enter");
                JLabel aadharNO = new JLabel("Enter aadhar number");
                JLabel abcId = new JLabel("Enter abcId");
                JLabel gender = new JLabel("Enter gender");
                JLabel fatherName = new JLabel("Enter father name");
                JLabel fatherPhone = new JLabel("Enter father phone number");
                JLabel attendance = new JLabel("Enter attendance");
                JLabel address = new JLabel("Enter address");
                JLabel cgpa=new JLabel("Enter CGPA");
                JLabel reg_no=new JLabel("Enter Registeration number");
                JLabel student_name=new JLabel("Enter your name");
                JTextField dobt=new JTextField(20);
                JTextField phonet=new JTextField(20);
                JTextField semestert=new JTextField(20);
                JTextField departmentt=new JTextField(20);
                JTextField aadharnot=new JTextField(20);
                JTextField abcIdt=new JTextField(20);
                JTextField gendert=new JTextField(20);
                JTextField fatherNamet=new JTextField(20);
                JTextField fatherPhonet=new JTextField(20);
                JTextField attendancet=new JTextField(20);
                JTextField addresst=new JTextField(20);
                JTextField cgpat=new JTextField(20);
                JTextField reg_not=new JTextField(20);
                JTextField student_namet=new JTextField(20);
                JButton submit=new JButton("Submit");
                JButton backButton = new JButton("Back to Student's Menu");
               
                mainPanel.setLayout(new GridLayout(15,2));
                mainPanel.add(dob);
                mainPanel.add(dobt);
                mainPanel.add(phoneno);
                mainPanel.add(phonet);
                mainPanel.add(semester);
                mainPanel.add(semestert);
                mainPanel.add(department);
                mainPanel.add(departmentt);
                mainPanel.add(aadharNO);
                mainPanel.add(aadharnot);
                mainPanel.add(abcId);
                mainPanel.add(abcIdt);
                mainPanel.add(gender);
                mainPanel.add(gendert);
                mainPanel.add(fatherName);
                mainPanel.add(fatherNamet);
                mainPanel.add(fatherPhone);
                mainPanel.add(fatherPhonet);
                mainPanel.add(attendance);
                mainPanel.add(attendancet);
                mainPanel.add(address);
                mainPanel.add(addresst);
                mainPanel.add(cgpa);
                mainPanel.add(cgpat);
                mainPanel.add(reg_no);
                mainPanel.add(reg_not);
                mainPanel.add(student_name);
                mainPanel.add(student_namet);
                mainPanel.add(backButton);
                mainPanel.add(submit);
                
                frame.add(mainPanel);
    frame.setVisible(true);
                submit.addActionListener(new ActionListener(){
                    @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                    String insertQuery = "INSERT INTO student (`DOB`, `Phone_no`, `Semester`, `Department`, `Aadhar_No`, `ABC_ID`, `Gender`, `Father_Name`, `Father_number`, `Attendence_of_last_Sem`, `Address_day_scholar`, `CGPA_of_last_Sem`, `Approve`) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'No')";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        
                    preparedStatement.setString(1, dobt.getText());
                    preparedStatement.setString(2, phonet.getText());
                    preparedStatement.setString(3,semestert.getText());
                    preparedStatement.setString(4, departmentt.getText());
                    preparedStatement.setString(5, aadharnot.getText());
                    preparedStatement.setString(6, abcIdt.getText());
                    preparedStatement.setString(7, gendert.getText());
                    preparedStatement.setString(8, fatherNamet.getText());
                    preparedStatement.setString(9, fatherPhonet.getText());
                    preparedStatement.setString(10, attendancet.getText());
                    preparedStatement.setString(11, addresst.getText());
                    preparedStatement.setString(12, cgpat.getText());
        
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "  Data has been successfully inserted into the student table.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        String teacherUpdateQuery = "UPDATE teacher SET `enrollment_status` = 'Yes' WHERE `reg_no` = ?";
                PreparedStatement teacherPreparedStatement = connection.prepareStatement(teacherUpdateQuery);
                teacherPreparedStatement.setString(1, departmentt.getText());
                int teacherRowsAffected = teacherPreparedStatement.executeUpdate();
                
                if (teacherRowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Teacher's table has been updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Teacher's table update failed.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                    
                    } else {
                        JOptionPane.showMessageDialog(null, "Insertion failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } 
                
                catch (SQLException i) {
                    i.printStackTrace();
                }}});
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();// Close the current frame and return to the student's menu
                    }
                });
    }
}

   
    

