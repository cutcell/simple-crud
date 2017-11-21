<%@ page pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Users</title>
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
    <h3>Users</h3>
    <br>

    <form action="add" method="get">
        <button type="submit" class="btn btn-primary">New user</button>
    </form>
    <br>


    <table class="table table-sm">
        <thead class="thead-light">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Phone</th>
            <th scope="col">E-Mail</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.phone}</td>
                <td>${u.email}</td>
                <td>
                    <div class="btn-toolbar" role="toolbar" aria-label="actionsToolbar">
                        <div class="btn-group mr-2" role="group" aria-label="editGroup">
                            <form action="edit" method="get">
                                <input type="hidden" name="userId" value="${u.id}">
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </form>
                        </div>
                        <div class="btn-group mr-2" role="group" aria-label="deleteGroup">
                            <form action="delete" method="post">
                                <input type="hidden" name="userId" value="${u.id}">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <form action="add" method="get">
        <button type="submit" class="btn btn-primary">New user</button>
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
