<%--
  Created by IntelliJ IDEA.
  User: alittlem1nd
  Date: 07.07.2017
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание роли</title>
</head>
<body>
<h2 align="center">Добавить роль</h2>
<div class="container" align="center">
    <form action='${pageContext.servletContext.contextPath}/createrole' method=post>
        Введите название новой роли: <input type='text' name='role'><br/>
        <input type='submit' value='Добавить роль'/>
    </form>
</div>
</body>
</html>
