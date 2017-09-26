<%--
  Created by IntelliJ IDEA.
  User: SpooN
  Date: 01.09.2017
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br/>
<br/>
<br/>

<c:choose>
    <c:when test="${userName ne ''}">
        <c:set var="linkAddition" value="/${userName}"/>
    </c:when>
    <c:otherwise>
        <c:set var="linkAddition" value=""/>
    </c:otherwise>

</c:choose>





<c:if test="${!empty usersList}">

    <table>
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="80">Age</th>
            <th width="80">isAdmin</th>
            <th width="120">Date Created</th>
            <th width="60">EDIT</th>
            <th width="60">DELETE</th>
            <c:forEach var="listUser" items="${usersList}">
        <tr>
            <td>${listUser.id}</td>
            <td>${listUser.name}</td>
            <td>${listUser.age}</td>
            <td>${listUser.admin}</td>
            <td>${listUser.date}</td>
            <td><a href="<c:url value="/users/edit/${listUser.id}" />"target="_blank" >EDIT</a></td>
            <td><a href="<c:url value="/users/delete/${listUser.id}${linkAddition}?page=${currentPage}"/>">DELETE</a></td>
        </tr>
        </c:forEach>
    </table>
</c:if>

<table>
    <tr>
<c:forEach begin="0" end="${pageCount-1}" varStatus="loop">
  <td>  <a href="<c:url value="/usersPage?page=${loop.index}"/>">${loop.index}</a> </td>
</c:forEach>
    </tr>
</table>

<br/>
<br/>
<br/>
<a href="<c:url value="/users/getForm"/>" target="_blank">Add a User</a>
<br/>
<br/>
<br/>

    <c:out value="Sort users by name"/>

   <form name="Sort By name" action="<c:url value="/users/find"/>" method="post">
     <table>
         <tr>
             <td><label for="UserName" >UserName</label></td>
             <td><input type="text" name="userName" id="UserName">${userName}</td>
         </tr>
          <tr>
              <td>
                  <input type="submit" name="Sort">

     </table>
   </form>

<c:if test="${userName ne ''}">
    <a href="<c:url value="/usersPage"/>">See all users</a>
</c:if>

</body>
</html>
