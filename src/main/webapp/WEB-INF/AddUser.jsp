
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<form action="add" method="post">
    <label>Name:</label>
    <input type="text" name="name"><br>
    <label>Phone:</label>
    <input type="tel" name="phone"><br>
    <label>Email</label>
    <input type="email" name="email"><br>
    <input type="submit" value="Add new user">
</form>

</body>
</html>
