<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Portfolios</title>
</head>
<body>
    <table border="1">
        <thead>
        <th>Name</th>
        <th>User</th>
        <th>Coins</th>
        <th>View</th>
        <th>Edit</th>
        <th>Delete</th>
        </thead>
        <tbody>
        <c:forEach items="${portfolios}" var="portfolio">
            <tr>
                <td><c:out value="${portfolio.name}"/></td>
                <td><c:out value="${portfolio.user.login}"/></td>
                <td><a href="/portfolio/coins/${portfolio.id}">Coins</a></td>
                <td><a href="/portfolio/get/${portfolio.id}">View</a></td>
                <td><a href="/portfolio/edit/${portfolio.id}">Edit</a></td>
                <td><a href="/portfolio/delete/${portfolio.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h4><a href="${pageContext.request.contextPath}/portfolio/add">Add new portfolio</a></h4>
</body>
</html>
