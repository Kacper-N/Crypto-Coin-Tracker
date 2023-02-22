<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List One Portfolio</title>
</head>
<body>
    <table border="1">
        <thead>
            <th>Name</th>
            <th>User</th>
        </thead>
        <tbody>
            <tr>
                <td><c:out value="${portfolio.name}"/></td>
                <td><c:out value="${portfolio.user}"/></td>
            </tr>
        </tbody>
    </table>
    <h4><a href="${pageContext.request.contextPath}/portfolio/all">Go back</a></h4>
</body>
</html>
