
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="inc/style_ath.css">

</head>
<body>
	<c:import url="inc/menu.jsp" />

	<h2>Authentification</h2>

	<form action="Auth" method="get">



			<label for="login">Login:</label>
			 <input type="text" id="login" name="login" value="" /><br /> 
			<label for="password">Mot de passe:</label> 
			<input type="password" id="password" name="password" value="" />
			
			<br /> <input type="submit" value="Login" />
	</form>

	<c:if test="${not empty errorMessage}">
		<p style="color: red;">${errorMessage}</p>
	</c:if>

</body>
</html>