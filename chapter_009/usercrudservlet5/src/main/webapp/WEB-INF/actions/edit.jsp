<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>База данных пользователей</title>
</head>
<body><br><br><br><br><br>
<h1 align="center">Редактирование пользователя</h1>
<br>
<h5 align="center">Нужно ввести <code>логин</code> пользователя, которого вы хотите отредактировать...</h5>
<br>
<form action="${pageContext.servletContext.contextPath}/edit" method="post">
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
            <td><input type="text" name="txtusername"></td>
        </tr>
        <tr>
            <th align="right">email:</th>
            <td><input type="email" name="txtemail"></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Редактировать"></td>
        </tr>
    </table>
</form>
<br><br><br>
<h4 align="center">Также вы можете:</h4><br>
<div class="container" align="center">
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/create'"
           value="Создать пользователя"><br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/delete'"
           value="Удалить пользователя"><br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/showall'"
           value="Показать всех пользователей"><br/>
</div>
</body>
</html>