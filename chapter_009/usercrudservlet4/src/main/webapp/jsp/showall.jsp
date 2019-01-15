<%@ page import="evgenyhodz.models.User" %>
<%@ page import="evgenyhodz.DBController" %>
<%@ page import="java.util.ArrayList" %>
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
<h1 align="center">Таблица пользователей</h1>
<br>
<div class="container" align="center">
    <table border="1">
        <tr>
            <th>Имя</th>
            <th>Логин</th>
            <th>Email</th>
            <th>Дата создания</th>
        </tr>
        <% DBController db = new DBController();
            ArrayList<User> users = db.get();
            if (!users.isEmpty() && users != null) {
                for (User user : users) {
                    String name = user.getName();
                    String login = user.getLogin();
                    String email = user.getEmail();
                    String date = user.getCreateDate().getDayOfMonth() + "/"
                            + user.getCreateDate().getMonth()
                            + "/" + user.getCreateDate().getYear();
        %>
        <tr>
            <td><%=name%>
            </td>
            <td><%=login%>
            </td>
            <td><%=email%>
            </td>
            <td><%=date%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
<br><br><br>
<h4 align="center">Также вы можете:</h4><br>
<div class="container" align="center">
    <input type="submit" onclick="location.href = 'create.jsp'" value="Создать пользователя"><br/>
    <input type="submit" onclick="location.href = 'delete.jsp'" value="Удалить пользователя"><br/>
    <input type="submit" onclick="location.href = 'edit.jsp'" value="Редактировать пользователя"><br/>
</div>
</body>
</html>