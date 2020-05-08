<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>

<table>
    <tr>
        <th>USER NAME</th>
        <th>USER SURNAME</th>
        <th>EMAIL</th>
        <th>PASSWORD</th>
        <th>PHONE</th>
        <th>USER ROLE</th>
    </tr>

    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.surName}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.phone}</td>
            <td>${user.userRole}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


