<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>База данных пользователей</title>
</head>
<body><br><br><br><br><br>
<h1 align="center">Создать пользователя</h1>
<br><br>
<form action='${pageContext.servletContext.contextPath}/create' method="post">
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
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/delete'" value="Удалить пользователя"><br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/edit'"
           value="Редактировать пользователя"><br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/showall'" value="Показать всех пользователей"><br/>
</div>
</body>
</html>

