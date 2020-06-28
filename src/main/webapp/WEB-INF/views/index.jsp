<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<div>
    <h2> Main page </h2>
    <sec:authorize access="isAuthenticated()">
        <h3>Hello, ${pageContext.request.userPrincipal.name}</h3>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/login">Войти</a></h4>
        <h4><a href="/register">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>
    <h4><a href="/user">User's page</a></h4>
    <h4><a href="/admin">List of users (admin access only)</a></h4>
</div>
</body>
</html>
