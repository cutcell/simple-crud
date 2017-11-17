<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New user</title>
</head>
<body>

<style>

    input[type=text] {
        width: 20%;
        padding: 12px 20px;
        margin: 12px;
        box-sizing: border-box;
        border: 1px solid black;
        outline: none;
    }

    input[type=tel] {
        width: 20%;
        padding: 12px 20px;
        margin: 12px;
        box-sizing: border-box;
        border: 1px solid black;
        outline: none;
    }

    input[type=email] {
        width: 20%;
        padding: 12px 20px;
        margin: 12px;
        box-sizing: border-box;
        border: 1px solid black;
        outline: none;
    }

    input[type=submit] {
        border-radius: 4px;

    }

</style>

<form action="view" method="post">
    <label>ID</label>
    <input type="text" name="id" value="${editUser.id}" readonly><br>
    <label>Name:</label>
    <input type="text" name="name" value="${editUser.name}"><br>
    <label>Phone:</label>
    <input type="tel" name="phone" value="${editUser.phone}"><br>
    <label>Email</label>
    <input type="email" name="email" value="${editUser.email}"><br>
    <input type="submit" value="Save">
</form>

</body>
</html>
