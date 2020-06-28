
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<h2> Users page</h2>

<div> This page can see only authorized users</div>

<div>
    <table>
        <tr>
            <td>
                User:
            </td>
            <td>
                ${username}
            </td>
        </tr>
        <tr>
            <td>
                Role:
            </td>
            <td>
                ${userrole}
            </td>
        </tr>
    </table>

</div>
</body>
</html>
