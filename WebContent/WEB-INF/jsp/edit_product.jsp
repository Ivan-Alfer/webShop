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
	<form action="${pageContext.request.contextPath}/Controller"
		method="post">
		<input type="hidden" name="command" value="edit_product" /> Category:<br />
		<c:forEach items="${requestScope.categories}" var="category">
			<c:choose>
				<c:when test="${category.categoryId==product.categoryId}">
					<input type="radio" name="categoryId"
						value="${category.categoryId}" checked>
					<c:out value="${category.productCategory}" />
				</c:when>
				<c:otherwise>
					<input type="radio" name="categoryId"
						value="${category.categoryId}">
					<c:out value="${category.productCategory}" />
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<br /> Firm:<br />
		<c:forEach items="${requestScope.firms}" var="firm">
			<c:choose>
				<c:when test="${firm.firmId==product.firmId}">
					<input type="radio" name="firmId" value="${firm.firmId}" checked>
					<c:out value="${firm.productFirm}" />
				</c:when>
				<c:otherwise>
					<input type="radio" name="firmId" value="${firm.firmId}">
					<c:out value="${firm.productFirm}" />
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<br /> Model:<br /> 
		<input type="text" name="productName" value="${product.productName}" /><br /> 
		Description:<br /> 
		<input type="text" name="productDescription" value="${product.productDescription}" /><br />
		Price:<br /> 
		<input type="text" name="productPrice" value="${product.productPrice}" /><br />
		<input type="submit" value="submit" /><br /> 
		<input type="hidden" name="productId" value="${product.productId}" />
	</form>

	<a href="${pageContext.request.contextPath}/administration/category">category</a>

</body>
</html>