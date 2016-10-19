<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	Hello,
	<!-- c:out value="${sessionScope.user.firstName}" / -->
	
	!

	<br />

	<c:set var="url" value="${requestScope.encodeURL}" />
	<c:if test="${url == null}">
		<c:set var="url" value="Controller" />
	</c:if>

	<form action="${url}" method="get">
		<input type="hidden" name="command" value="show_category" /> 
		<input type="submit" name="show category" value="show category" />
	</form>
	
	
	<a href="${pageContext.request.contextPath}/shop/basket">go to basket</a>
	<br/>
	<a href="${pageContext.request.contextPath}/logout">logout</a>
	
</body>
</html>