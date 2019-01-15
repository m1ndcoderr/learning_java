<%@ page import="evgenyhodz.models.User" %>
<%@ page import="evgenyhodz.DBController" %>
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
<h1 align="center">Таблица пользователей</h1>
<br>
<table align="center" border="2">
    <tr>
        <th> Имя</th>
        <th> Логин</th>
        <th> Email</th>
        <th> Дата создания</th>
    </tr>
    <% for (User user : new DBController().get()) {%>
    <tr>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getLogin()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
        <td><%=user.getCreateDate().toString()%>
        </td>
    </tr>
    <%}%>
</table>
<br><br><br>
<h4 align="center">Также вы можете:</h4><br>
<div class="btn-group-lg" align="center">
    <button class="btn btn-primary btn-danger btn-lg" onclick="location.href = 'delete.jsp'">Удалить пользователя
    </button>
    <button class="btn btn-primary btn-primary btn-lg" onclick="location.href = 'create.jsp'">Создать пользователя
    </button>
    <button class="btn btn-primary btn-success btn-lg" onclick="location.href = 'edit.jsp'">Редактировать пользователя
    </button>
</div>
</body>
</html>