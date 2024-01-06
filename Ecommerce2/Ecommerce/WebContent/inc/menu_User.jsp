<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../inc/style.css">

</head>
<body>
	<div>
    <nav>
        <ul>
            <li><a href="<%= request.getContextPath()%>/HomeUser">Home</a></li>
            <li><a href="<%= request.getContextPath()%>/CommandesUser">Mes Commandes</a></li>
            <li><a href="<%= request.getContextPath()%>/Panier">Mon Panier</a></li>
            <li><a href="<%= request.getContextPath()%>/ProfileUser">Profile</a></li>
            <li><a href="<%= request.getContextPath()%>/Logout">Logout</a></li>
            <li><a href="<%= request.getContextPath()%>/User/About.jsp">À propos</a></li>
        </ul>
    </nav>
</div>

</body>
</html>