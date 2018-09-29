<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@include file="Header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<div class="container">
<spring:form action="${pageContext.request.contextPath}/addCategory" modelAttribute="cat" method="post">
<div class="form-group">
<c:if test="${not empty cat.categoryName}">
<label for=cid>Category Id:</label>
<spring:input type="text" id="cid" class="form-class" path="categoryId" readonly="true" disabled="true"/>
<spring:hidden path="categoryId"/>
</c:if>
</div>
<div class="form-group">
<label for=cname>Category Name:</label>
<spring:input type="text" path="categoryName" id="cdes" class="form-control"/><br>
</div>
<div class="form-group">
<label for=cname>Category Description:</label>
<spring:input type="text" path="categoryDescription" id="cdes" class="form-control"/><br>
</div>
<c:if test="${empty cat.categoryName}"><input type="submit" value="Add"/></c:if>
<c:if test="${not empty cat.categoryName}"><input type="submit" value="Update"/></c:if>

</div>
</spring:form>


<c:if test="${not empty categoryList}">

<table border="1">
<tr><td>categoryId</td>
<td>categoryName</td>
<td>categoryDesc</td>

<td>Edit</td>
<td>delete</td>
</tr>
<c:forEach items="${categoryList}" var="cate">
<tr>
<td>${cate.categoryId}</td>
<td>${cate.categoryName}</td>
<td>${cate.categoryDescription}</td>

<td><a href="<c:out value="editCategory/${cate.categoryId}"></td></c:out>">edit</a>
<td><a href="<c:out value="deleteCategory/${cate.categoryId}"></td></c:out>">delete</a>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>