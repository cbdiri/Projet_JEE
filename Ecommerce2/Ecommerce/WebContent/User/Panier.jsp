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

	<c:if test="${ empty produits}">
	<h3> Panier est vide </h3>
	</c:if>
	
<c:if test="${not empty produits}">
	<c:set var="totalMontant" value="0" />
<c:forEach var="index" begin="0" end="${produits.size() - 1}" varStatus="status">

    <form action=Panier method="post">
        <input type="hidden" name="Panier_Produit" value="${Panier_Produits[index].id}" />
     
        <div class="div2">
            <table>
                <tr>
                    <td>
                        <img src="${produits[index].path_photo}" alt="Image" style="width: 170px; height: 200px;" />
                    </td>
                    <td>
                      <label>Panier_Produit.id : ${Panier_Produits[index].id}</label>
                     <br/>
                     <label>Article : ${produits[index].name}</label>
                     <br/>
                     <label> Quantité : ${Panier_Produits[index].quantite}</label>
                     <input type="text" name="qte" />
                     <br/>
                     <label> prix_unitaire : ${Panier_Produits[index].prix_unitaire} </label>
                     <input type="hidden" name="prix_unitaire" value="${Panier_Produits[index].prix_unitaire} " />
                  
                     <br/>
                     <label> montant_total : ${Panier_Produits[index].montant_total}</label>
                     <br/>
                     
                      <button type="submit" name="action" value="delete" style="color: white; background-color: red; width: 100px;">Delete</button>
          			  <button type="submit" name="action" value="edit" style="color: white; background-color: blue; width: 100px;">Edit</button>
                    </td>
                </tr>
            </table>
        </div>

    </form>
    <br/>
    <c:set var="totalMontant" value="${totalMontant + Panier_Produits[index].montant_total}" />
</c:forEach>

<form action="CommandesUser" method="post">
	<div class="div2">
	<label> <strong>  Total Montant : ${totalMontant} DT/TTC </strong> </label>
	 <input type="hidden" name="Montant_commande" value="${totalMontant} " />
	
     <button type="submit" name="action" value="cmd" style="color: white; background-color: green; width: 150;">Commander</button>
</div>
</form>
</c:if>

</body>
</html>