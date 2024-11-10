import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// Class representing a single course
class Course {
    private String courseName;
    private int credits;

    // Constructor to initialize course name and credits
    public Course(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    // Getter method for course name
    public String getCourseName() {
        return courseName;
    }

    // Getter method for course credits
    public int getCredits() {
        return credits;
    }
}

// Class representing a single grade for a course
class Grade {
    private Course course;
    private double score;

    // Constructor to initialize grade with a course and score
    public Grade(Course course, double score) {
        this.course = course;
        this.score = score;
    }

    // Getter method for course
    public Course getCourse() {
        return course;
    }

    // Getter method for grade score
    public double getScore() {
        return score;
    }
}

// Class representing a student with grades and GPA calculation
class Student {
    private String studentID;
    private String name;
    private List<Grade> grades;

    // Constructor to initialize student with ID and name
    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    // Method to add a grade for a course
    public void addGrade(Course course, double score) {
        grades.add(new Grade(course, score));
    }

    // Method to calculate GPA based on grades and course credits
    public double calculateGPA() {
        double totalScore = 0;
        int totalCredits = 0;
        // Iterate through grades and calculate weighted score and total credits
        for (Grade grade : grades) {
            totalScore += grade.getScore() * grade.getCourse().getCredits();
            totalCredits += grade.getCourse().getCredits();
        }
        // GPA is calculated as weighted score divided by total credits
        return totalCredits == 0 ? 0 : totalScore / totalCredits;
    }

    // Getter method for student ID
    public String getStudentID() {
        return studentID;
    }

    // Getter method for student name
    public String getName() {
        return name;
    }

    // Getter method for the list of grades
    public List<Grade> getGrades() {
        return grades;
    }
}

// Main application class to create and manage the GradeBook UI
public class GradeBookApp {
    private JFrame frame;  // Main application window
    private JTextField studentIDField; // Field to enter student ID
    private JTextField nameField; // Field to enter student name
    private JTextField courseNameField; // Field to enter course name
    private JTextField creditsField; // Field to enter course credits
    private JTextField scoreField; // Field to enter grade score
    private JTextArea outputArea; // Text area to display output (e.g., added courses, GPA)
    private Student student; // The current student object for the application

    // Constructor to set up the GUI components and layout
    public GradeBookApp() {
        frame = new JFrame("Student Grade Book");  // Create the frame with a title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        frame.setSize(400, 500); // Set window size
        frame.setLayout(new GridLayout(9, 2)); // Grid layout for the UI components

        // Initialize all the input fields and text area
        studentIDField = new JTextField();
        nameField = new JTextField();
        courseNameField = new JTextField();
        creditsField = new JTextField();
        scoreField = new JTextField();
        outputArea = new JTextArea();
        outputArea.setEditable(false); // Make output area read-only

        // Create the "Add Course" button and define action on click
        JButton addButton = new JButton("Add Course");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCourse(); // Add course to the student's record
            }
        });

        // Create the "Calculate GPA" button and define action on click
        JButton calculateButton = new JButton("Calculate GPA");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGPA(); // Calculate and display the GPA
            }
        });

        // Add all components (labels, fields, buttons) to the frame
        frame.add(new JLabel("Student ID:"));
        frame.add(studentIDField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Course Name:"));
        frame.add(courseNameField);
        frame.add(new JLabel("Credits:"));
        frame.add(creditsField);
        frame.add(new JLabel("Score:"));
        frame.add(scoreField);
        frame.add(addButton);
        frame.add(calculateButton);
        frame.add(new JLabel("Output:"));
        frame.add(outputArea);

        // Make the frame visible to the user
        frame.setVisible(true);
    }

    // Method to add a course and grade to the student's record
    private void addCourse() {
        if (student == null) {
            // If student is not initialized, create a new student using entered ID and name
            student = new Student(studentIDField.getText(), nameField.getText());
        }
        // Get course information from user input fields
        String courseName = courseNameField.getText();
        int credits = Integer.parseInt(creditsField.getText()); // Convert to integer
        double score = Double.parseDouble(scoreField.getText()); // Convert to double

        // Create a new course object and add it to the student's grades
        Course course = new Course(courseName, credits);
        student.addGrade(course, score);
        
        // Display the added course and score in the output area
        outputArea.append("Added course: " + courseName + " with score " + score + "\n");
    }

    // Method to calculate and display the GPA of the student
    private void calculateGPA() {
        if (student != null) {
            // Calculate the GPA of the student
            double gpa = student.calculateGPA();
            // Display the GPA in the output area
            outputArea.append("GPA: " + gpa + "\n");
        }
    }

    // Main method to launch the GradeBook application
    public static void main(String[] args) {
        new GradeBookApp(); // Create an instance of the app, which initializes the UI
    }
}
