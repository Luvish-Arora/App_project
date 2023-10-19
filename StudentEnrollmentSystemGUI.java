package App_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentEnrollmentSystemGUI {
    private static JTextArea studentDetailsTextArea;

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
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

    // Load the logo image
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Srm logo\\srm logo (3).png"); // Replace with the actual path

    // Create a label to display the logo
        JLabel logoLabel = new JLabel(logoIcon);

        JButton teacherButton = new JButton("Teacher");
        JButton studentButton = new JButton("Student");
        JButton exitButton = new JButton("Exit");

        frame.add(logoLabel, BorderLayout.NORTH); // Add the logo at the top
        frame.add(teacherButton);
        frame.add(studentButton);
        frame.add(exitButton);

        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTeacherMenu();
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

        frame.setVisible(true);
    }

    private static void handleTeacherMenu() {
        JFrame teacherFrame = new JFrame("Teacher Menu");
        teacherFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        teacherFrame.setSize(400, 300);
        teacherFrame.setLayout(new GridLayout(4, 1));

        JButton viewAllDetailsButton = new JButton("View all student details");
        JButton viewParticularDetailButton = new JButton("View particular student detail");
        JButton displayTableButton = new JButton("Display teacher table");
        JButton approveStudentButton = new JButton("Approve a student");
        JButton backButton = new JButton("Back");

        teacherFrame.add(viewAllDetailsButton);
        teacherFrame.add(viewParticularDetailButton);
        teacherFrame.add(displayTableButton);
        teacherFrame.add(approveStudentButton);
        teacherFrame.add(backButton);

        viewAllDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllStudentDetails();
            }
        });

        viewParticularDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for viewing a particular student's details
            }
        });

        displayTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for displaying the teacher table
            }
        });

        approveStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for approving a student
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
        studentFrame.setSize(400, 300);
        studentFrame.setLayout(new GridLayout(3, 1));

        JButton insertDetailsButton = new JButton("Insert student details");
        JButton checkStatusButton = new JButton("Check approval status");
        JButton backButton = new JButton("Back");

        studentFrame.add(insertDetailsButton);
        studentFrame.add(checkStatusButton);
        studentFrame.add(backButton);

        insertDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for inserting student details
            }
        });

        checkStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic for checking approval status
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
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            StringBuilder details = new StringBuilder();

            while (resultSet.next()) {
                // Retrieve and append student details
                details.append("Date of Birth: ").append(resultSet.getDate("DOB")).append("\n");
                details.append("Phone Number: ").append(resultSet.getInt("Phone_no")).append("\n");
                details.append("Semester: ").append(resultSet.getInt("Semester")).append("\n");
                details.append("Department: ").append(resultSet.getString("Department")).append("\n");
                details.append("Aadhar Number: ").append(resultSet.getInt("Aadhar_No")).append("\n");
                details.append("ABC ID: ").append(resultSet.getString("ABC_ID")).append("\n");
                details.append("Gender: ").append(resultSet.getString("Gender")).append("\n");
                details.append("Father Name: ").append(resultSet.getString("Father_Name")).append("\n");
                details.append("Father Number: ").append(resultSet.getInt("Father_number")).append("\n");
                details.append("Attendance of Last Semester: ").append(resultSet.getInt("Attendence_of_last_Sem")).append("\n");
                details.append("Address (Day Scholar): ").append(resultSet.getString("Address_day_scholar")).append("\n");
                details.append("CGPA of Last Semester: ").append(resultSet.getInt("CGPA_of_last_Sem")).append("\n");
                details.append("Approval Status: ").append(resultSet.getString("Approve")).append("\n\n");
            }

            // Display the student details in a JTextArea
            studentDetailsTextArea.setText(details.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // ... (rest of your methods)
}
