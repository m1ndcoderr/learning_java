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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
            integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
            integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link href="<c:url value="/resources/css/common_styles.css" />" rel="stylesheet">

    <title>Car Details</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/basic.do">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/signin.do">Sign in</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/signup.do">Sign up</a>
            </li>
        </ul>
        <button class="btn btn-outline-default my-2 my-sm-0" id="quit" type="button">Quit</button>
    </div>
</nav>
<div class="jumbotron">
    <h1 class="display-3">Car Details</h1>
    <hr class="my-4">
    <div class="cut_jumbo">
        Quick and easy return to basic page by click on button
        <button type="button" class="btn btn-default" onclick="location.href='../html/basic.html'">Return to Car Store
        </button>
    </div>
</div>

<!-- Waiting element :  -->
<div class="loading_element" id="loading">
    <p>Loading car...</p>
    <p><img src="../gif/ajax-loader.gif"/>
</div>

<!-- Car details will be draw here :  -->
<div id="car_details" align="center"></div>

<!-- Footer: -->
<footer class="footer">
    <p>Made by Evgeny Khodzitskiy, evgeny.hodz@gmail.com, GitHub:
        <a href="https://github.com/alittlemind" target="_blank">alittlemind</a></p>
</footer>
<!-- End of Footer -->
</body>
</html>
