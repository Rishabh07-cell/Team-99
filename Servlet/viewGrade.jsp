<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Grades</title>
</head>
<body>
    <h1>Welcome, ${student.firstName} ${student.lastName}</h1>
    <p>Student ID: ${student.studentID}</p>

    <h2>Grades:</h2>
    <table border="1">
        <tr>
            <th>Course</th>
            <th>Course Code</th>
            <th>Grade</th>
        </tr>
        <c:forEach var="grade" items="${grades}">
            <tr>
                <td>${grade.courseName}</td>
                <td>${grade.courseCode}</td>
                <td>${grade.grade}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="logout.jsp">Logout</a>
</body>
</html>
