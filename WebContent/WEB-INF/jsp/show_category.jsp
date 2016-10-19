<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<c:forEach items="${requestScope.category}" var="category">
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/show_product?id=${category.idCategory}"	><c:out value="${category.nameCategory}" /></a>
				</td>
			</tr>
			<br/>
		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath}/logout">logout</a>
	

</body>
</html>