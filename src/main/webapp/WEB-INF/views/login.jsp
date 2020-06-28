<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>

<body>

<h1>Log in form</h1>
<h4>Please enter your login and password</h4>

<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div>
    <form method="POST" action="/login">

        <table>
            <tr>
                <td>Login</td>
                <td><input type="text" name="username" placeholder="Login"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" placeholder="Password"/></td>
            </tr>
            <tr>
                <td><input name="submit" type="submit" value="Log in" /></td>
            </tr>
            
        </table>
    </form>
</div>

</body>
</html>
