<%--
  Created by IntelliJ IDEA.
  User: SpooN
  Date: 01.09.2017
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User</title>
</head>
<body>

<c:choose>
    <c:when test="${! empty user.name}">
        <c:out value="Edit a User"/>
    </c:when>
    <c:otherwise>
        <c:out value="Add a User"/>
    </c:otherwise>
</c:choose>

<c:url var="addAction" value="/users/add"/>
<form:form method="post" action="${addAction}" commandName="user">
    <table>
        <c:if test="${! empty user.name}">
            <tr>
                <td><form:label path="id"/>ID</td>
                <td><form:input path="id" readonly="true"/></td>
            </tr>
        </c:if>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="age">Age</form:label></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><form:label path="admin">Admin?</form:label></td>
            <td><form:checkbox path="admin"/></td>
        </tr>
        <c:if test="${! empty user.name}">
            <tr>

                <td><form:label path="date">Creation Date</form:label></td>
                <td><form:input path="date" readonly="true"/></td>

            </tr>
        </c:if>

        <tr>
            <c:if test="${! empty user.name}">
                <td colspan = "2">
                    <input type = "submit" value = "Edit a User"/>
                </td>
            </c:if>
            <c:if test="${ empty user.name}">
                <td colspan="2">
                    <input type="submit" value="Add a User"/>
                </td>
            </c:if>
        </tr>
    </table>
</form:form>





</body>
</html>
