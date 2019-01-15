<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.name}"/>
                </td>
                <td><c:out value="${user.login}"/>
                </td>
                <td><c:out value="${user.email}"/>
                </td>
                <td><c:out value="${user.createDate}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br><br><br>
<h4 align="center">Также вы можете:</h4><br>
<div class="container" align="center">
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/create'"
           value="Создать пользователя"><br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/delete'"
           value="Удалить пользователя"><br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/edit'"
           value="Редактировать пользователя"><br/>
</div>
</body>
</html>