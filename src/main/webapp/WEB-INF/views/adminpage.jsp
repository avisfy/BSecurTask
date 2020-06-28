<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List of users</title>
</head>

<body>
<h2> Table of all users in dbase</h2>

<div>This table avaliable only for users with role ADMIN</div>

<div>
    <table>
        <thead>
        <th>Id</th>
        <th>login</th>
        <th>Password</th>
        <th>Role</th>
        </thead>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.role.role}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/register">Регистрация</a>
<%--    <a href="/">Главная</a>--%>
</div>
</body>
</html>
