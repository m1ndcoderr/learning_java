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
<h1 align="center">Удаление пользователя</h1>
<p align="center">Нужно ввести <code>логин</code> пользователя, затем нажать кнопку "удалить":</p>
<br><br>
<form action="<%=request.getContextPath()%>/delete" method="post">
    <div class="navbar-form" align="center">
        <input type="text" class="span2" placeholder="Введите логин..." name="txtlogin">
        <button type="submit" class="btn-danger btn-lg">Удалить</button>
    </div>
</form>
<br><br><br>
<h4 align="center">Также вы можете:</h4><br>
<div class="btn-group-lg" align="center">
    <button class="btn btn-primary btn-primary btn-lg" onclick="location.href = 'create.jsp'">Создать пользователя
    </button>
    <button class="btn btn-primary btn-success btn-lg" onclick="location.href = 'edit.jsp'">Редактировать
        пользователя
    </button>
    <button class="btn btn-primary btn-primary btn-lg" onclick="location.href = 'showall.jsp'">Увидеть всех
        пользователей
    </button>
</div>
</body>
</html>