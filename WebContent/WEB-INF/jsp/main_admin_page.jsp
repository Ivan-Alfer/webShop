<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello,ADMIN!
	<br/>
	<a href="${pageContext.request.contextPath}/administration/category">category</a>
	<br/>
	<a href="${pageContext.request.contextPath}/administration/all_products">all products</a>
	<br/>
</body>
</html>