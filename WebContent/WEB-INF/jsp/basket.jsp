<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${sessionScope.products}" var="product">
		<tr>
			<td><c:out value="${product.productCategory}" /></td>
			<td><c:out value="${product.productFirm}" /></td>
			<td><c:out value="${product.productName}" /></td>
			<td><c:out value="${product.productDescription}" /></td>
			<td><c:out value="${product.productPrice}" /></td>
			<td><a href="${pageContext.request.contextPath}/delete_from_basket?id=${product.productId}">delete from basket</a></td>
		</tr>
		<br />
	</c:forEach>
	<a href="${pageContext.request.contextPath}/logout">logout</a>

</body>
</html>