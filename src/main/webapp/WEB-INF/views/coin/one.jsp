<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List One User</title>
</head>
<body>
    <table border="1">
        <thead>
        <th>Login</th>
        <th>Email</th>
        <th>Password</th>
        </thead>
        <tbody>
        <tr>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.password}"/></td>
        </tr>
        </tbody>
    </table>
    <h4><a href="${pageContext.request.contextPath}/user/all">Go back</a></h4>
</body>
</html>
