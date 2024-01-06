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
<body class="inscription-body">
	<c:import url="inc/menu.jsp" />
	<h2>Inscription Utilisateur</h2>

	<form action="Auth" method="post" >


		<label for="name">Nom:</label>
		<input type="text" id="name" name="name" value="${param.name}" /><br />

		<label for="email">Email:</label>
		<input type="text" id="email" name="email" value="${param.email}" /><br />

		<label for="login">Login:</label>
		<input type="text" id="login" name="login" value="${param.login}" /><br />

		<label for="password">Mot de passe:</label>
		<input type="password" id="password" name="password" value="${param.password}" /><br />

		<label for="tel">Téléphone:</label>
		<input type="text" id="tel" name="tel" value="${param.tel}" /><br />

		<input type="submit" value="Enregistrer" />
		<br/>
			<p style="color: green;"  >${Message}</p>
	</form>
	
</body>

</html>