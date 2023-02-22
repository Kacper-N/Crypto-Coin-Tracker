<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm delete of the book</title>
</head>
<body>
    <form:form method="post" modelAttribute="id">
        <p>
            <input type="submit" value="CONFIRM">
        </p>
        <p>
            <button type="button"><a href="${pageContext.request.contextPath}/user/all">CANCEL</a></button>
        </p>
    </form:form>
</body>
</html>
