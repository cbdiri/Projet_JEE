<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/inc/style.css"></head>	

</head>
<body>
	<c:import url="../inc/menu_User.jsp" />
<form>
 <table border="1">
        <thead>
            <tr>
                <th>ID Commande</th>
                <th>ID Produit</th>
                <th>Quantité</th>
                <th>Prix unitaire</th>
                <th>Montant total</th>
    
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cp" items="${CP}">
                <tr>
                    <td>${cp.id_Commande}</td>
                    <td>${cp.id_produit}</td>
                    <td>${cp.quantite}</td>
                    <td>${cp.prix_unitaire}</td>
                    <td>${cp.montant_total}</td>
             
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form>



</body>
</html>