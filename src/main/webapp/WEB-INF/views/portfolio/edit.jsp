<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Portfolio</title>
</head>
<body>
    <form:form method="post" action="/portfolio/update" modelAttribute="portfolio">
        <p>
            <form:hidden path="id"/>
        </p>
        <p>
            <form:label path="name">Name</form:label>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="user">User</form:label>
            <form:input path="user"/>
        </p>
        <p>
            <input type="submit" value="Edit">
        </p>
    </form:form>
    <h4><a href="${pageContext.request.contextPath}/portfolio/all">Go back</a></h4>
</body>
</html>
