<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New user</title>
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
    <h3>New user</h3>
    <br>

    <form action="add" method="post">

        <%--login--%>
        <div class="form-group row">
            <label for="loginFormInput" class="col-1 col-form-label">Login</label>
            <div class="col-4">
                <input type="text" class="form-control" id="loginFormInput" name="login">
            </div>
        </div>

        <%--password--%>
        <div class="form-group row">
            <label for="passwordFormInput" class="col-1 col-form-label">Password</label>
            <div class="col-4">
                <input type="text" class="form-control" id="passwordFormInput" name="password">
            </div>
        </div>

        <%--role--%>
        <div class="form-group row">
            <label for="roleFormInput" class="col-1 col-form-label">Role</label>
            <div class="col-4">
                <select class="form-control" id="roleFormInput" name="role">
                    <option>user</option>
                    <option>admin</option>
                </select>
            </div>
        </div>

        <%--name--%>
        <div class="form-group row">
            <label for="nameFormInput" class="col-1 col-form-label">Name</label>
            <div class="col-4">
                <input type="text" class="form-control" id="nameFormInput" name="name">
            </div>
        </div>

        <%--phone--%>
        <div class="form-group row">
            <label for="phoneFormInput" class="col-1 col-form-label">Telephone</label>
            <div class="col-4">
                <input type="tel" class="form-control" id="phoneFormInput" name="phone">
            </div>
        </div>

        <%--email--%>
        <div class="form-group row">
            <label for="emailFormInput" class="col-1 col-form-label">E-Mail</label>
            <div class="col-4">
                <input type="email" class="form-control" id="emailFormInput" name="email">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-4">
                <button type="submit" class="btn btn-primary">Add new user</button>
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
