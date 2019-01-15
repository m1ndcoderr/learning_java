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
</head>
<body><br><br><br><br><br>
<h1 align="center">Создать пользователя</h1>
<br><br>
<form action="<%=request.getContextPath()%>/create" method="post">
    <div class="container" align="center">
        Имя: <input type="text" name="name"><br/>
        Логин: <input type="password" name="login"><br/>
        Email: <input type="email" name="email"><br/>
        <input type="submit" value="Создать">
    </div>
</form>
<br>
<h4 align="center">Также вы можете:</h4><br>
<div class="container" align="center">
    <input type="submit" onclick="location.href = 'delete.jsp'" value="Удалить пользователя"><br/>
    <input type="submit" onclick="location.href = 'edit.jsp'" value="Редактировать пользователя"><br/>
    <input type="submit" onclick="location.href = 'showall.jsp'" value="Показать всех пользователей"><br/>
</div>
</body>
</html>

