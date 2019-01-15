<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ввести логин</title>
</head>
<body>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<br/><br/><br/>
<div class="container" align="center">
    <form action='${pageContext.servletContext.contextPath}/signin' method=post>
        Войти: <input type='password' name='login'><br/><br/>
        <c:if test="${error !=''}">
        <div style="background-color: red" align="center">
            <c:out value="${error}"/>
        </div>
        <input type='submit'/> <br/>
    </form>
    </c:if>
</div>
</body>
</html>
