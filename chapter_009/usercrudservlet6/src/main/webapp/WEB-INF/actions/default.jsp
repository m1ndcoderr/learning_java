<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Стартовая default страница</title>
</head>
<body>
<h3 align="center"> В этой <code>БД</code> вы можете: </h3> <br/>
<c:if test="${user.role.name == 'admin'}">
<div class="container" align="center">
    <h5 align="center">Действия с пользователями</h5>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/create'"
           value="Создать пользователя"><br/> <br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/delete'"
           value="Удалить пользователя"><br/> <br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/edit'"
           value="Редактировать пользователя"><br/> <br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/showall'"
           value="Показать всех пользователей"><br/> <br/>
    <h5 align="center">Действия с ролями</h5>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/createrole'"
           value="Создать новую роль"><br/> <br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/editrole'"
           value="Редактировать роль"><br/> <br/>
    <input type="submit" onclick="location.href = '${pageContext.servletContext.contextPath}/deleterole'"
           value="Удалить роль"><br/> <br/>
    </c:if>
    <c:if test="${user.role.name!='admin'}">
        <br><br>
        <h4 align="center">Редактирование пользователя</h4>
        <br>
        <form action="${pageContext.servletContext.contextPath}/edit" method="post">
            <p align="center">Введите новые <code>имя</code> и <code>email</code>:</p>
            <table align="center">
                <tr>
                    <th align="right">Имя:</th>
                    <td><input type="text" name="txtusername"></td>
                </tr>
                <tr>
                    <th align="right">login:</th>
                    <td><input type="email" name="txtlogin" value="${user.login}" readonly="readonly"></td>
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
    </c:if>
</div>
</body>
</html>
