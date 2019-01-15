<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Default page</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: whitesmoke;
        }

        .navbar-inverse {
            background-color: lightblue;
        }

        .navbar-inverse .navbar-nav > li > a {
            text-align: center;
            color: black;
        }

        .navbar-inverse .navbar-nav .caret {
            color: black;
        }

        .navbar-inverse .navbar-nav > .dropdown {
            color: whitesmoke;
        }

        .navbar-nav {
            float: none;
            margin: 0 auto;
            display: table;
            table-layout: fixed;
        }

        .jumbotron {
            margin-bottom: 0;
            background-color: lightblue;
        }

        footer {
            background-color: lightblue;
            position: absolute;
            left: 0;
            bottom: 0;
            height: 50px;
            width: 100%;
            overflow: hidden;
        }

        .center-block {
            display: block;
            margin-left: 700px;
            margin-right: 700px;
        }
    </style>
</head>
<body>

<!-- If user is Admin condition -->

<c:if test="${user.role.name == 'admin'}">

    <!-- Navigation bar. -->

    <nav class="navbar-inverse navbar-fixed-top">
        <div class="jumbotron">
            <div class="container text-center">
                <h1>User database</h1>
                <p>Create, edit or delete accounts</p>
            </div>
        </div>
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">User actions
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a onclick="$('#createbox').show(); $('#deletebox').hide(); $('#editbox').hide(); $('#showallbox').hide(); $('#showallrolesbox').hide(); $('#editrolebox').hide(); $('#deleterolebox').hide(); $('#createrolebox').hide();">Create
                                user</a></li>
                        <li>
                            <a onclick="$('#createbox').hide(); $('#deletebox').show(); $('#editbox').hide(); $('#showallbox').hide(); $('#showallrolesbox').hide(); $('#editrolebox').hide(); $('#deleterolebox').hide(); $('#createrolebox').hide();">Delete
                                user</a></li>
                        <li>
                            <a onclick="$('#createbox').hide(); $('#deletebox').hide(); $('#editbox').show(); $('#showallbox').hide(); $('#showallrolesbox').hide(); $('#editrolebox').hide(); $('#deleterolebox').hide(); $('#createrolebox').hide();">Edit
                                user</a>
                        </li>
                        <li>
                            <a onclick="$('#createbox').hide(); $('#deletebox').hide(); $('#editbox').hide(); $('#showallbox').show(); $('#showallrolesbox').hide(); $('#editrolebox').hide(); $('#deleterolebox').hide(); $('#createrolebox').hide();">Show
                                all users</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Role actions
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a onclick="$('#createbox').hide(); $('#deletebox').hide(); $('#editbox').hide(); $('#showallbox').hide(); $('#showallrolesbox').hide(); $('#editrolebox').hide(); $('#deleterolebox').hide(); $('#createrolebox').show();">Create
                                role</a></li>
                        <li>
                            <a onclick="$('#createbox').hide(); $('#deletebox').hide(); $('#editbox').hide(); $('#showallbox').hide(); $('#showallrolesbox').hide(); $('#editrolebox').show(); $('#deleterolebox').hide(); $('#createrolebox').hide();">Edit
                                role</a></li>
                        <li>
                            <a onclick="$('#createbox').hide(); $('#deletebox').hide(); $('#editbox').hide(); $('#showallbox').hide(); $('#showallrolesbox').hide(); $('#editrolebox').hide(); $('#deleterolebox').show(); $('#createrolebox').hide();">Delete
                                role</a></li>
                        <li>
                            <a onclick="$('#createbox').hide(); $('#deletebox').hide(); $('#editbox').hide(); $('#showallbox').hide(); $('#showallrolesbox').show(); $('#editrolebox').hide(); $('#deleterolebox').hide(); $('#createrolebox').hide();">Show
                                all roles</a></li>
                    </ul>
                </li>
                <li style="right: 0%; position: absolute">
                    <a onclick="location.href = '${pageContext.servletContext.contextPath}/signin'"><span
                            class="glyphicon glyphicon-log-in"></span> Log out</a>
                </li>
            </ul>
        </div>
    </nav>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>


    <!--User creation window -->

    <div id="createbox" style="display:none; margin-top:50px" class="center-block">
        <div class="panel panel-info">
            <div class="panel-heading" style="background-color: lightblue">
                <div class="panel-title" align="center" style="color: black">Create a user</div>
            </div>
            <div class="panel-body" align="center">
                <form id="signupform" class="form-horizontal" role="form"
                      action='${pageContext.servletContext.contextPath}/create' method=post>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Username</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="name" placeholder="Username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Email</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="email" placeholder="Email Address">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Login</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="login" placeholder="Login/Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Role</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="role_id" placeholder="Unique ID">
                        </div>
                    </div>
                    <!-- Country + city : AJAX -->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Country</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="country" placeholder="Country">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">City</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="city" placeholder="City">
                        </div>
                    </div>

                    <div class="form-group" align="center">
                        <input type="submit" class="btn btn-primary" value="Create">
                    </div>
                </form>
            </div>
        </div>
    </div>


    <!-- Delete user window-->

    <div id="deletebox" style="margin-top:50px; display: none" class="center-block">
        <div class="panel panel-info">
            <div class="panel-heading" style="background-color: lightblue">
                <div class="panel-title" align="center">Delete user</div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                <form id="loginform" class="form-horizontal" role="form"
                      action='${pageContext.servletContext.contextPath}/delete' method=post>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Login</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="txtlogin"
                                   placeholder="Enter the login of user you want to delete">
                        </div>
                    </div>
                    <div class="form-group" align="center">
                        <input type="submit" class="btn btn-danger" value="Delete">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <br/>
    <br/>


    <!-- User edit window -->

    <div id="editbox" style="display:none; margin-top:50px" class="center-block">
        <div class="panel panel-info">
            <div class="panel-heading" style="background-color: lightgreen">
                <div class="panel-title" align="center" style="color: black">Edit user</div>
            </div>
            <div class="panel-body" align="center">
                <form id="editform" class="form-horizontal" role="form"
                      action='${pageContext.servletContext.contextPath}/edit' method=post>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Login</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="txtlogin"
                                   placeholder="Login/Password to edit that user">
                        </div>
                    </div>
                    <br/>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Username</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="txtusername" placeholder="Username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Email</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="txtemail" placeholder="Email Address">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Role</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="role_id" placeholder="Unique ID">
                        </div>
                    </div>
                    <!-- Country + city : AJAX -->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Country</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="country" placeholder="Country">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">City</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="city" placeholder="City">
                        </div>
                    </div>

                    <div class="form-group" align="center">
                        <input type="submit" class="btn btn-primary" value="Edit">
                    </div>
                </form>
            </div>
        </div>
    </div>


    <!-- Show All table. -->

    <div class="center-block" style="display:none" id="showallbox">
        <h3 align="center">Table of existing users</h3>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Name</th>
                <th>Login</th>
                <th>Email</th>
                <th>Creation date</th>
                <th>Role</th>
                <th>Country</th>
                <th>City</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.name}"/>
                    </td>
                    <td><c:out value="${user.login}"/>
                    </td>
                    <td><c:out value="${user.email}"/>
                    </td>
                    <td><c:out value="${user.createDate}"/>
                    </td>
                    <td>
                        <c:out value="${user.role.name}"/>
                    </td>
                    <td><c:out value="${user.country}"/>
                    </td>
                    <td><c:out value="${user.city}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <!-- Create role box. -->

    <div id="createrolebox" style="margin-top:50px; display: none" class="center-block">
        <div class="panel panel-info">
            <div class="panel-heading" style="background-color: lightblue">
                <div class="panel-title" align="center">Create role</div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <div style="display:none" id="login-alertion" class="alert alert-danger col-sm-12"></div>
                <form id="createroleform" class="form-horizontal" role="form"
                      action='${pageContext.servletContext.contextPath}/createrole' method=post>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Role:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="role"
                                   placeholder="Rolename">
                        </div>
                    </div>
                    <div class="form-group" align="center">
                        <input type="submit" class="btn btn-primary" value="Create role">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <br/>
    <br/>


    <!-- Edit role box -->

    <div id="editrolebox" style="margin-top:50px; display: none" class="center-block">
        <div class="panel panel-info">
            <div class="panel-heading" style="background-color: lightgreen">
                <div class="panel-title" align="center">Edit role</div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <div style="display:none" class="alert alert-danger col-sm-12"></div>
                <form class="form-horizontal" role="form"
                      action='${pageContext.servletContext.contextPath}/editrole' method=post>
                    <div class="form-group">
                        <label class="col-md-3 control-label">ID:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="role_id"
                                   placeholder="Enter unique ID to change rolename">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">New rolename:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="role"
                                   placeholder="Rolename">
                        </div>
                    </div>
                    <div class="form-group" align="center">
                        <input type="submit" class="btn btn-success" value="Edit role">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <br/>
    <br/>


    <!-- Delete role box -->

    <div id="deleterolebox" style="margin-top:50px; display: none" class="center-block">
        <div class="panel panel-info">
            <div class="panel-heading" style="background-color: lightblue">
                <div class="panel-title" align="center">Delete role</div>
            </div>
            <div style="padding-top:30px" class="panel-body">
                <div style="display:none" class="alert alert-danger col-sm-12"></div>
                <form class="form-horizontal" role="form"
                      action='${pageContext.servletContext.contextPath}/deleterole' method=post>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Delete by ID:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="role_id"
                                   placeholder="Unique ID">
                        </div>
                    </div>
                    <div class="form-group" align="center">
                        <input type="submit" class="btn btn-danger" value="Delete role">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <br/>
    <br/>

    <!-- Show all roles box -->

    <div class="center-block" style="display:none" id="showallrolesbox">
        <h3 align="center">Table of existing roles</h3>
        <table class="table table-bordered">
            <thead>
            <tr>
            <tr>
                <th>ID</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td><c:out value="${role.id}"/>
                    </td>
                    <td><c:out value="${role.name}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <!-- End of Admin version of code here -->
</c:if>


<!-- If user is not admin -->

<c:if test="${user.role.name!='admin'}">

    <div class="jumbotron">
        <div class="container text-center">
            <h1>User database</h1>
            <p>As a simple user, you can edit your account</p>
            <ul class="nav navbar-nav">
                <li style="right: 0%; position: absolute">
                    <a onclick="location.href = '${pageContext.servletContext.contextPath}/signin'"><span
                            class="glyphicon glyphicon-log-in"></span> Log out</a>
                </li>
            </ul>
        </div>
    </div>
    </div>
    <div style="margin-top:50px" class="center-block">
        <div class="panel panel-info">
            <div class="panel-heading" style="background-color: lightblue">
                <div class="panel-title" align="center" style="color: black">Edit user</div>
            </div>
            <div class="panel-body" align="center">
                <form class="form-horizontal" role="form"
                      action='${pageContext.servletContext.contextPath}/edit' method=post>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Login</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="login"
                                   value="${user.login}" readonly="readonly">
                        </div>
                    </div>
                    <br/>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Username</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="txtname" placeholder="Username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Email</label>
                        <div class="col-md-9">
                            <input type="email" class="form-control" name="txtemail" placeholder="Email Address">
                        </div>
                    </div>
                    <!-- Country + city : AJAX -->
                    <div class="form-group">
                        <label class="col-md-3 control-label">Country</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="country" placeholder="Country">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">City</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control" name="city" placeholder="City">
                        </div>
                    </div>
                    <div class="form-group" align="center">
                        <input type="submit" class="btn btn-primary" value="Edit">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- End of user (not admin) version of code -->
</c:if>

<!-- Footer. -->

<footer class="footer">
    <div class="container" align="center">
        <span class="text-muted">Made by Evgeny Khodzitskiy, evgeny.hodz@gmail.com</span>
    </div>
    <div class="container" align="center">
        <span class="text-muted">GitHub: <a href="https://github.com/alittlemind">alittlemind</a> </span>
    </div>
</footer>

</body>
</html>
