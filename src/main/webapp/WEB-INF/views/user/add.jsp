<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add User</title>
</head>
<body>
    <form:form method="post" modelAttribute="user">
        <p>
            <form:label path="login">Login</form:label>
            <form:input path="login"/>
        </p>
        <p>
            <form:label path="email">Email</form:label>
            <form:input path="email"/>
        </p>
        <p>
            <form:label path="password">Password</form:label>
            <form:input path="password"/>
        </p>
        <p>
            <input type="submit" value="Add">
        </p>
    </form:form>
    <h4><a href="${pageContext.request.contextPath}/user/all">Go back</a></h4>
</body>
</html>
