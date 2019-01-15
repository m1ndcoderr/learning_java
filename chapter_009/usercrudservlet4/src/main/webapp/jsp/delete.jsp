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
<h1 align="center">Удаление пользователя</h1>
<p align="center">Нужно ввести <code>логин</code> пользователя, затем нажать кнопку "удалить":</p>
<br><br>
<form action="<%=request.getContextPath()%>/delete" method="post">
    <div class="container" align="center">
        <input type="text" name="txtlogin"><br/>
        <input type="submit" value="Удалить"><br/>
    </div>
</form>
<br><br><br>
<h4 align="center">Также вы можете:</h4><br>
<div class="container" align="center">
    <input type="submit" onclick="location.href = 'create.jsp'" value="Создать пользователя"><br/>
    <input type="submit" onclick="location.href = 'edit.jsp'" value="Редактировать пользователя"><br/>
    <input type="submit" onclick="location.href = 'showall.jsp'" value="Показать всех пользователей"><br/>
</div>
</body>
</html>