<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../inc/style.css">
    
<body>

	<div>
    <nav>
        <ul>
            <li><a href="<%= request.getContextPath()%>/HomeA">Home</a></li>
            <li><a href="<%= request.getContextPath()%>/ArticlesAdmin">Articles</a></li>
            <li><a href="<%= request.getContextPath()%>/CommandesAdmin">Commandes</a></li>
            <li><a href="<%= request.getContextPath()%>/UtilisateursAdmin">Utilisateurs</a></li>
            <li><a href="<%= request.getContextPath()%>/ProfileAdmin">Profile</a></li>
            <li><a href="<%= request.getContextPath()%>/Logout">Logout</a></li>
            <li><a href="<%= request.getContextPath()%>/Admin/About.jsp">À propos</a></li>
        </ul>
    </nav>
</div>

</body>
</html>