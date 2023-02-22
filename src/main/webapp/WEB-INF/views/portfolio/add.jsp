<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Portfolio</title>
</head>
<body>
        <form:form method="post" modelAttribute="portfolio">
            <p>
                <form:label path="name">Name</form:label>
                <form:input path="name"/>
            </p>
<%--            LIST USERÓW ROZWIJANA--%>
<%--            <p>--%>
<%--                <form:label path="user">User</form:label>--%>
<%--                <form:select path="user" items="${logins}"/>--%>
<%--            </p>--%>
            <p>
                <form:label path="user">User</form:label>
                <form:input path="user"/>
            </p>
            <p>
                <input type="submit" value="Add">
            </p>
        </form:form>
    <h4><a href="${pageContext.request.contextPath}/portfolio/all">Go back</a></h4>
</body>
</html>
