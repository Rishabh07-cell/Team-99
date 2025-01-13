<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile - ${student.firstName} ${student.lastName}</title>
</head>
<body>
    <h2>Welcome, ${student.firstName} ${student.lastName}</h2>

    <h3>Personal Information:</h3>
    <p><strong>First Name:</strong> ${student.firstName}</p>
    <p><strong>Last Name:</strong> ${student.lastName}</p>
    <p><strong>Date of Birth:</strong> <fmt:formatDate value="${student.dateOfBirth}" pattern="dd MMM yyyy" /></p>
    <p><strong>Gender:</strong> ${student.gender == 'M' ? 'Male' : 'Female'}</p>

    <h3>Courses Enrolled:</h3>
    <table border="1">
        <thead>
            <tr>
                <th>Course Name</th>
                <th>Course Code</th>
                <th>Grade</th>
            </tr>
        </thead>
        <tbody>
            <!-- JSTL loop to display courses and grades -->
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseName}</td>
                    <td>${course.courseCode}</td>
                    <td>${course.grade}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br/>
    <a href="logout.jsp">Logout</a>
</body>
</html>
