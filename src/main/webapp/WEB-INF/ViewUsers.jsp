<%@ page pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Users</title>
</head>
<body>
<h2>Users</h2>

<form action="add" method="get">
    <input type="submit" value="New user">
</form>
<br>

<style>

    table {
        width: 50%;
        height: 40px;
        border: 1px solid black;
        border-collapse: collapse;
        border-radius: 4px;
    }

    th, td {
        border: 1px solid black;
        text-align: left;
        padding: 10px;
    }

    th {
        background-color: lightgray;
        color: black;
    }

    tr:hover {
        background-color: #f5f5f5
    }

    input[type=submit] {
        border-radius: 4px;
    }

</style>


<table>

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>E-Mail</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${userList}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.phone}</td>
            <td>${u.email}</td>
            <td>
                <form action="edit" method="get">
                    <input type="hidden" name="userId" value="${u.id}">
                    <input type="submit" value="Edit">
                </form>
                <form action="delete" method="post">
                    <input type="hidden" name="userId" value="${u.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

<br>
<form action="add" method="get">
    <input type="submit" value="New user">
</form>

</body>
</html>
