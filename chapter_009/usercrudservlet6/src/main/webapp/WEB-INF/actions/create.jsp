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
        Role: <input type="text" name="role_id"><br/>
        <input type="submit" value="Создать">
    </div>
</form>
</body>
</html>

