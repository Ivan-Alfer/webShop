<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Logination</h1>
	<c:if test="${requestScope.errorMessage != null}">
		<c:out value="${requestScope.errorMessage}"/>
	</c:if>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="logination" /> Login:<br />
		<input type="text" name="login" value="" /><br /> Password:<br />
		<input type="password" name="password" value="" /><br /> 
		<input type="submit" value="sign in" />
	</form>
	
	
	<c:set var="url" value="${requestScope.encodeURL}"/>
	<c:if test="${url == null}">
		<c:set var="url" value="Controller" />
	</c:if>
	
	
	<form action="${url}" method="get">
    	<input type="hidden" name="command" value="go_to_registration" /> 
 		<input type="submit" name="registration"  value="registration"/>
 	</form> 
  
 <form action="${url}" method="get">
    <input type="hidden" name="command" value="show_category" /> 
 	<input type="submit" name="show category"  value="show category"/>
 </form> 
 	
</body>
</html>