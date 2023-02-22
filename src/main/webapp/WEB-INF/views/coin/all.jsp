<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Coins</title>
</head>
<body>
    <table border="1">
        <thead>
        <th>Name</th>
        <th>Amount</th>
        <th>Portfolio</th>
        <th>Transactions</th>
        <th>View</th>
        <th>Edit</th>
        <th>Delete</th>
        </thead>
        <tbody>
        <c:forEach items="${coins}" var="coin">
            <tr>
                <td><c:out value="${coin.name}"/></td>
                <td><c:out value="${coin.amount}"/></td>
                <td><c:out value="${coin.portfolio.name}"/></td>
                <td><a href="/transaction/get/${coin.id}">View</a></td>
                <td><a href="/coin/get/${coin.id}">View</a></td>
                <td><a href="/coin/edit/${coin.id}">Edit</a></td>
                <td><a href="/coin/delete/${coin.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h4><a href="${pageContext.request.contextPath}/coin/add">Add new coin</a></h4>
</body>
</html>
