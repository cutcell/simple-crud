<%@ page pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Users</title>
</head>
<body>
<h1>Users</h1>

<a href="/users/view?add">Add user</a>
<br>
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
        padding: .5em;
    }

    th {
        background-color: darkgray;
        color: black;
    }

    tr:hover {background-color: #f5f5f5}

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
            <td><a href="/users/view?edit=${u.id}">edit</a>&nbsp;&nbsp;<a href="/users/view?delete=${u.id}">delete</a></td>
        </tr>
    </c:forEach>

</table>

<br>
<a href="/users/view?add">Add user</a>

</body>
</html>
