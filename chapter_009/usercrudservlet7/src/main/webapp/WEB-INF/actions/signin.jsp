<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sign in</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: whitesmoke;
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
    </style>
</head>
<body>
<br/>
<div class="jumbotron">
    <div class="container text-center">
        <h1>User database</h1>
        <p>Create, edit or delete accounts</p>
    </div>
</div>
<br/><br/><br/>
<div class="container">
    <div class="row">
        <div id="loginbox" style="margin-top:50px;" class="col-sm-6 col-md-offset-3">
            <div class="panel panel-info">
                <div class="panel-heading" style="background-color: lightblue">
                    <div class="panel-title" align="center">Log in</div>
                </div>
                <div style="padding-top:30px" class="panel-body">
                    <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                    <form id="loginform" class="form-horizontal" role="form"
                          action='${pageContext.servletContext.contextPath}/signin' method="post">
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input id="login-password" type="password" class="form-control" name="login"
                                   placeholder="Password">
                        </div>
                        <div style="margin-top:10px" class="form-group">
                            <div class="col-sm-12 controls" align="center">
                                <c:if test="${error !=''}">
                                    <div align="center" style="color: red">
                                        <c:out value="${error}"/>
                                    </div>
                                    <br/>
                                    <input type="submit" class="btn btn-primary" value="Ok">
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12 control">
                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                                    Don't have an account?
                                    <a onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                        Sign up!
                                    </a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div id="signupbox" style="display:none; margin-top:50px" class="col-sm-6 col-md-offset-3">
            <div class="panel panel-info">
                <div class="panel-heading" style="background-color: lightblue">
                    <div class="panel-title">Sign up</div>
                    <div style="float:right; font-size: 85%; position: relative; top:-10px">
                        <a id="signinlink" onclick="$('#signupbox').hide(); $('#loginbox').show()"> Log in</a></div>
                </div>
                <div class="panel-body">
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
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-9">
                                <input type="submit" class="btn btn-primary" value="Register" align="center">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<br/>
<br/>
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
