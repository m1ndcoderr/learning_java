<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>База данных пользователей</title>
</head>
<body><br><br><br><br><br>
<h1 align="center">Удаление пользователя</h1>
<p align="center">Нужно ввести <code>логин</code> пользователя, затем нажать кнопку "удалить":</p>
<br><br>
<form action="${pageContext.servletContext.contextPath}/delete" method="post">
    <div class="container" align="center">
        <input type="text" name="txtlogin"><br/>
        <input type="submit" value="Удалить"><br/>
    </div>
</form>
</body>
</html>