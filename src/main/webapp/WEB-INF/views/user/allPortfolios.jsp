<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User Portfolios</title>
</head>
<body>
    <table border="1">
        <thead>
            <th>User Portfolios</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <tbody>
            <c:forEach items="${portfolios}" var="portfolio">
                <tr>
                    <td><c:out value="${portfolio.name}"/></td>
                    <td><a href="/user/portfolios/${user.id}">Portfolios</a></td>
                    <td><a href="/user/get/${user.id}">View</a></td>
                    <td><a href="/user/edit/${user.id}">Edit</a></td>
                    <td><a href="/user/delete/${user.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h4><a href="${pageContext.request.contextPath}/user/all">Go back</a></h4>
</body>
</html>
