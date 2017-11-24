<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit user</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">
</head>
<body>

<div class="container-fluid">

    <br>
    <h3>Edit user</h3>
    <br>

    <form action="edit" method="post">

        <div class="form-group row">
            <label for="idFormInput" class="col-1 col-form-label">ID</label>
            <div class="col-4">
                <input type="text" readonly class="form-control-plaintext" id="idFormInput"
                       value="${editUser.id}" name="id">
            </div>
        </div>

        <%--login--%>
        <div class="form-group row">
            <label for="loginFormInput" class="col-1 col-form-label">Login</label>
            <div class="col-4">
                <input type="text" class="form-control" id="loginFormInput"
                       value="${editUser.login}" name="login">
            </div>
        </div>

        <%--password--%>
        <div class="form-group row">
            <label for="passwordFormInput" class="col-1 col-form-label">Password</label>
            <div class="col-4">
                <input type="text" class="form-control" id="passwordFormInput"
                       value="${editUser.password}" name="password">
            </div>
        </div>

        <%--role--%>
        <div class="form-group row">
            <label for="roleFormInput" class="col-1 col-form-label">Role</label>
            <div class="col-4">
                <input type="text" class="form-control" id="roleFormInput"
                       value="${editUser.role}" name="role">
            </div>
        </div>

        <%--name--%>
        <div class="form-group row">
            <label for="nameFormInput" class="col-1 col-form-label">Name</label>
            <div class="col-4">
                <input type="text" class="form-control" id="nameFormInput"
                       value="${editUser.name}" name="name">
            </div>
        </div>

        <%--phone--%>
        <div class="form-group row">
            <label for="phoneFormInput" class="col-1 col-form-label">Telephone</label>
            <div class="col-4">
                <input type="tel" class="form-control" id="phoneFormInput"
                       value="${editUser.phone}" name="phone">
            </div>
        </div>

        <%--email--%>
        <div class="form-group row">
            <label for="emailFormInput" class="col-1 col-form-label">E-Mail</label>
            <div class="col-4">
                <input type="email" class="form-control" id="emailFormInput"
                       value="${editUser.email}" name="email">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-4">
                <button type="submit" class="btn btn-primary">Save changes</button>
            </div>
        </div>

    </form>

</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
</body>
</html>
