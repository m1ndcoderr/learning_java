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
<br><br><br>
<h4 align="center">Также вы можете:</h4><br>
<div class="container" align="center">
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/create'"
           value="Создать пользователя"><br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/edit'"
           value="Редактировать пользователя"><br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/showall'"
           value="Показать всех пользователей"><br/>
</div>
</body>
</html>