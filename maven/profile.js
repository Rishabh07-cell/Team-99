<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h2>Welcome to your Profile, ${student.firstName} ${student.lastName}</h2>

    <h3>Personal Information:</h3>
    <p><strong>First Name:</strong> ${student.firstName}</p>
    <p><strong>Last Name:</strong> ${student.lastName}</p>
    <p><strong>Date of Birth:</strong> ${student.dateOfBirth}</p>
    <p><strong>Gender:</strong> ${student.gender == 'M' ? 'Male' : 'Female'}</p>

    <a href="logout.jsp">Logout</a>
</body>
</html>
