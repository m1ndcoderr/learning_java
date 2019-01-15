<%--
  Created by IntelliJ IDEA.
  User: alittlem1nd
  Date: 07.07.2017
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление роли</title>
</head>
<body>
<br><br><br><br><br>
<h1 align="center">Удаление роли</h1>
<p align="center">Нужно ввести <code>id</code> роли, затем нажать кнопку "удалить":</p>
<br><br>
<form action="${pageContext.servletContext.contextPath}/deleterole" method="post">
    <div class="container" align="center">
        <input type="text" name="role_id"><br/>
        <input type="submit" value="Удалить"><br/>
    </div>
</form>
</body>
</html>
