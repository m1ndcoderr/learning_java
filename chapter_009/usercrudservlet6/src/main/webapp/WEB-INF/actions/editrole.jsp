<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alittlem1nd
  Date: 07.07.2017
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование роли</title>
</head>
<body>
<h2 align="center">Редактировать роль</h2>
<br>
<h5 align="center">Нужно ввести <code>id</code> роли, название которой вы хотите изменить...</h5>
<br>
<form action="${pageContext.servletContext.contextPath}/editrole" method="post">
    <table align="center">
        <tr>
            <th align="right">id:</th>
            <td><input type="text" name="role_id" placeholder="Введите id..."></td>
        </tr>
    </table>
    <br>
    <p align="center">...и новое название роли:</p>
    <table align="center">
        <tr>
            <th align="right">Роль:</th>
            <td><input type="text" name="role"></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Редактировать"></td>
        </tr>
    </table>
</form>
<br><br><br>
<h2 align="center">Таблица имеющихся ролей</h2>
<br>
<div class="container" align="center">
    <table border="1">
        <tr>
            <th>id</th>
            <th>Роль</th>
        </tr>
        <c:forEach items="${roles}" var="role">
            <tr>
                <td><c:out value="${role.id}"/>
                </td>
                <td><c:out value="${role.name}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
