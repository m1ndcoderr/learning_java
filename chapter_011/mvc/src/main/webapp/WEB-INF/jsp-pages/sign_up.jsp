<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: alittlem1nd
  Date: 04.10.2017
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
            integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
            integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
            crossorigin="anonymous"></script>

    <link href="<c:url value="/resources/css/common_styles.css" />" rel="stylesheet">

    <title>Sign up</title>
</head>
<body>
<div class="jumbotron">
    <h1 class="display-3">Sign up</h1>
    <p class="lead">Create an account to buy or to sell cars. Enter your personal data in the sign up form
        below.</p>
    <hr class="my-4">
    <div class="cut_jumbo">
        Quick and easy return to basic page by click on button
        <button type="button" class="btn btn-default" onclick="location.href='../html/basic.html'">Return to Car Store
        </button>
    </div>
</div>
<div class="sign_up_form">
    <div class="form-group">
        <h3 style="padding-bottom: 20px">Sign up form</h3>
        <input type="text" class="form-control" id="name" placeholder="Introduce yourself">
        <input type="text" class="form-control" id="password" placeholder="Create a password">
        <input type="text" class="form-control" id="email" placeholder="Type your email">
        <input type="text" class="form-control" id="phone" placeholder="Type your phone number">
        <input type="text" class="form-control" id="url" placeholder="Link to your page in social network">
    </div>
    <div>
        <div class="btn-group">
            <button type="button" class="btn btn-default" id="sign_up">Register</button>
        </div>
        <div id="error_or_success_message">
            <div class="alert alert-success" id="positive_message">Account successfully created. Auto redirect...</div>
            <div class="alert alert-danger" id="negative_message">All fields required. Check your input.</div>
        </div>
        <div style="padding-top: 10px; margin-bottom: -35px">
            <hr class="my-4" style="margin-bottom: -15px;">
            <p>Already have an account?
                <button type="button" class="btn btn-default" onclick="location.href='../html/sign_in.html'">Sign in
                </button>
            </p>
        </div>
    </div>
    <br>
</div>

<!-- Footer -->
<footer class="footer" style="text-align: center">
    <p>Made by Evgeny Khodzitskiy, evgeny.hodz@gmail.com, GitHub:
        <a href="https://github.com/alittlemind" target="_blank">alittlemind</a></p>
</footer>
<!-- End of Footer -->
</body>
</html>
