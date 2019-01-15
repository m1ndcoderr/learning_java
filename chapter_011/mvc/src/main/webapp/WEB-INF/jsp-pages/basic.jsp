<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: alittlem1nd
  Date: 04.10.2017
  Time: 18:23
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

    <title> Car Store Welcome page </title>
</head>
<body>
<div class="wrapper">
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
        <h1 class="display-1">Car Store</h1>
        <p class="lead">Buy or sell your car with the Car Store (maybe someday it will be the best online platform for
            buying and selling cars. Well, for now...)</p>
        <hr class="my-4">
        <div class="cut_jumbo">
            Sell your car here! Click this:
            <button type="button" class="btn btn-default" onclick="location.href='${pageContext.servletContext.contextPath}/add_new_adv.do'">Add new
                advertisement
            </button>
        </div>
    </div>

    <!-- Table with car advertisements will be draw here :  -->
    <div id="cars_table" align="center" style="margin-bottom: 70px;">${advertisements}</div>

    <!-- Footer -->
    <footer class="footer">
        <p>Made by Evgeny Khodzitskiy, evgeny.hodz@gmail.com, GitHub:
            <a href="https://github.com/alittlemind" target="_blank">alittlemind</a></p>
    </footer>
    <!-- End of Footer -->
</div>
</body>
</html>
