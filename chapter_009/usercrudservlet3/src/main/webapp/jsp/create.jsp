<%--
  Created by IntelliJ IDEA.
  User: alittlem1nd
  Date: 21.06.2017
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>База данных пользователей</title>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <link href="../css/bootstrap.css" type="text/css" rel="stylesheet">
    <script src="../js/bootstrap.js"></script>
</head>
<body><br><br><br><br><br>
<h1 align="center">Создание нового пользователя</h1>
<br><br>
<form action="<%=request.getContextPath()%>/create" method="post">
    <div class="well">
        <div class="container" align="center">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <div class="form-group-row">
                    <input type="text" class="form-control form-control-lg text-center" name="name"
                           placeholder="Введите имя...">
                </div>
            </div>
            <br>
            <br>
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <div class="form-group-row">
                    <input type="password" class="form-control form-control-lg text-center" name="login"
                           placeholder="Введите логин...">
                </div>
            </div>
            <br>
            <br>
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <div class="form-group-row">
                    <input type="email" class="form-control form-control-lg text-center" name="email"
                           placeholder="Введите почту...">
                </div>
            </div>
            <br>
            <br>
            <button onmousedown="create()" type="submit" class="btn-default btn-lg">Создать</button>
            <script>
                function create() {
                    var nameVar = document.getElementByName("name").value;
                    var loginVar = document.getElementByName("login").value;
                    var emailVar = document.getElementByName("email").value;
                    console.log("Вы создали пользователя с данными: " + nameVar + ", " + loginVar + ", " + emailVar);
                }
            </script>
        </div>
    </div>
</form>
<br>
<h4 align="center">Также вы можете:</h4><br>
<div class="btn-group-lg" align="center">
    <button class="btn btn-primary btn-danger btn-lg" onclick="location.href = 'delete.jsp'">Удалить пользователя
    </button>
    <button class="btn btn-primary btn-primary btn-lg" onclick="location.href = 'edit.jsp'">Редактировать
        пользователя
    </button>
    <button class="btn btn-primary btn-success btn-lg" onclick="location.href = 'showall.jsp'">Увидеть всех
        пользователей
    </button>
</div>
</body>
</html>

