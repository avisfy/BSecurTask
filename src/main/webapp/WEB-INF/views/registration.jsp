<%--<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create new user</title>
</head>
<body>

<h1>Registration form</h1>
<h4>Please register here</h4>

<c:url var="actionUrl" value="/register"/>
<form:form action="/register" method="POST" modelAttribute="user">
<table>
    <tr>
        <td>Login</td>
        <td><form:input type="text" path="login"/></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><form:input type="password" path="password"/></td>
    </tr>
    <tr>
        <td>Confirm password</td>
        <td><form:input type="password" path="passwordConfirm"/></td>
        <form:errors path="password"/>
        <td> ${passwordError}</td>
    </tr>

    <tr>
        <td>
            <input type="submit" value="Save new user"/>
        </td>
    </tr>
</table>
</form:form>

<br/>
</body>
</html>