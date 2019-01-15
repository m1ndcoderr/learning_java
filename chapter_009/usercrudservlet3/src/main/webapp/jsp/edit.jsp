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
<h1 align="center">Редактирование пользователя</h1>
<br>
<h5 align="center">Нужно ввести <code>логин</code> пользователя, которого вы хотите отредактировать...</h5>
<br>
<form action="<%=request.getContextPath()%>/edit" method="post">
    <table align="center">
        <tr>
            <th align="right">Логин:</th>
            <td><input type="password" name="txtlogin" placeholder="Введите логин..."></td>
        </tr>
    </table>
    <br>
    <p align="center">...и новые <code>имя</code> и <code>email</code>:</p>
    <table align="center">
        <tr>
            <th align="right">Имя:</th>
            <td><input type="text" name="txtusername" placeholder="Введите Имя..."></td>
        </tr>
        <tr>
            <th align="right">email:</th>
            <td><input type="email" name="txtemail" placeholder="Введите почту..."></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Создать" class="btn btn-success"></td>
        </tr>
    </table>
</form>
<br><br><br>
<h4 align="center">Также вы можете:</h4><br>
<div class="btn-group-lg" align="center">
    <button class="btn btn-primary btn-danger btn-lg" onclick="location.href = 'delete.jsp'">Удалить пользователя
    </button>
    <button class="btn btn-primary btn-primary btn-lg" onclick="location.href = 'create.jsp'">Создать пользователя
    </button>
    <button class="btn btn-primary btn-success btn-lg" onclick="location.href = 'showall.jsp'">Увидеть всех
        пользователей
    </button>
</div>
</body>
</html>