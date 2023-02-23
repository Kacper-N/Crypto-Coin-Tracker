<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Transactions</title>
</head>
<body>
    <table border="1">
        <thead>
        <th>Coin Transactions</th>
        <th>Transaction Type</th>
        <th>Quantity</th>
        <th>Purchase Price</th>
        <th>Value</th>
        <th>Currency</th>
        <th>Commission</th>
        <th>Transaction Fee</th>
        <th>Date Of Purchase</th>
        <th>Crypto Exchange Name</th>
        <th>Stored On</th>
        <th>Description</th>
        <th>View</th>
        <th>Edit</th>
        <th>Delete</th>
        </thead>
        <tbody>
        <c:forEach items="${transactions}" var="transaction">
            <tr>
                <td><c:out value="${transaction.coin.name}"/></td>
                <td><c:out value="${transaction.transactionType}"/></td>
                <td><c:out value="${transaction.quantity}"/></td>
                <td><c:out value="${transaction.purchasePrice}"/></td>
                <td><c:out value="${transaction.value}"/></td>
                <td><c:out value="${transaction.currency}"/></td>
                <td><c:out value="${transaction.commission}"/></td>
                <td><c:out value="${transaction.transactionFee}"/></td>
                <td><c:out value="${transaction.dateOfPurchase}"/></td>
                <td><c:out value="${transaction.cryptoExchangeName}"/></td>
                <td><c:out value="${transaction.storedOn}"/></td>
                <td><c:out value="${transaction.description}"/></td>
                <td><a href="/user/get/${transaction.id}">View</a></td>
                <td><a href="/user/edit/${transaction.id}">Edit</a></td>
                <td><a href="/user/delete/${transaction.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h4><a href="${pageContext.request.contextPath}/transaction/add">Add new transaction</a></h4>
</body>
</html>
