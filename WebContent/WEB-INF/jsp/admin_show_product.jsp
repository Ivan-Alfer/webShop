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
	<table>
		<tr>
			<td>Category</td>
			<td>Firm</td>
			<td>Model</td>
			<td>Description</td>
			<td>Price</td>
		</tr>
		
		
		<c:forEach items="${requestScope.products}" var="product">
			<tr>
				<td><c:out value="${product.productCategory}" /></td>
				<td><c:out value="${product.productFirm}" /></td>
				<td><c:out value="${product.productName}" /></td>
				<td><c:out value="${product.productDescription}" /></td>
				<td><c:out value="${product.productPrice}" /></td>
				
				<td>
					<a href="${pageContext.request.contextPath}/administration/edit_product?id=${product.productId}">edit product</a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/administration/delete_product?id=${product.productId}">delete product</a>
				</td>
			</tr>
			<br/>
		</c:forEach>
	</table>

	<a href="${pageContext.request.contextPath}/administration/add_product?categoryId=${param.id}">add product</a>
	<br/>
	<a href="${pageContext.request.contextPath}/administration/category">category</a>
	<br/>
	<a href="${pageContext.request.contextPath}/logout">logout</a>
</body>
</html>