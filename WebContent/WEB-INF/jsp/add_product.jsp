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
	<h1>ADMIN</h1>
	 <form action="${pageContext.request.contextPath}/Controller" method="post">
	<input type="hidden" name="command" value="add_product" /> 
	Name:<br />
	<input type="text" name="name" value="" /><br /> 
	Description:<br />
	<input type="text" name="description" value="" /><br />
	Price:<br />
	<input type="text" name="price" value="" /><br />
	Firm:<br />
	<c:forEach items="${requestScope.firms}" var ="firm">
		<input type="radio" name="firmId" value= "${firm.firmId}"><c:out value="${firm.productFirm}"/><br/>
	</c:forEach>
	<input type="hidden" name="categoryId" value="${param.categoryId}" />
	<input type="submit" value="submit" />
	<br/>
	</form> 
	<br/>
	
	
	
	<a href="${pageContext.request.contextPath}/administration/category">category</a>
	<br/>
</body>
</html>