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
            <th>Роль</th>
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
                <td>
                    <c:out value="${user.role.name}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>