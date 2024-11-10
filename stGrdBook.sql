-- Create the Database
CREATE DATABASE StudentGradebook;
USE StudentGradebook;

-- Create the Students Table
CREATE TABLE Students (
    StudentID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Gender CHAR(1)
);

-- Create the Courses Table
CREATE TABLE Courses (
    CourseID INT PRIMARY KEY AUTO_INCREMENT,
    CourseName VARCHAR(100),
    CourseCode VARCHAR(10)
);

-- Create the Grades Table with Foreign Keys
CREATE TABLE Grades (
    GradeID INT PRIMARY KEY AUTO_INCREMENT,
    StudentID INT,
    CourseID INT,
    Grade CHAR(2),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

-- Insert Sample Data into Students Table
INSERT INTO Students (FirstName, LastName, DateOfBirth, Gender) VALUES
('John', 'Doe', '2000-01-15', 'M'),
('Jane', 'Smith', '2001-02-20', 'F');

-- Insert Sample Data into Courses Table
INSERT INTO Courses (CourseName, CourseCode) VALUES
('Mathematics', 'MATH101'),
('English', 'ENG102');

-- Insert Sample Data into Grades Table
INSERT INTO Grades (StudentID, CourseID, Grade) VALUES
(1, 1, 'A'),
(1, 2, 'B'),
(2, 1, 'A'),
(2, 2, 'A');
