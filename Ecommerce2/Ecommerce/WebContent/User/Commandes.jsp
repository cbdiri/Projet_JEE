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
<br/>
    <c:forEach var="cmd" items="${cmd}">
    	<form action="DetailsCMD" method="get"> 
                <input type="hidden" name="commande_id" value="${cmd.id}" />
    
            <fieldset>
            <legend>Commande n°${cmd.id}</legend>
   
            <div class="div2">
                <label>Date de commande:</label>
                <span> ${cmd.date_commande} </span>
            </div>
            <div class="div2">
                <label>Montant de commande:</label>
                <span> <strong> ${cmd.montant_commande} DT/TTC </strong></span>
            </div>
  
            <div class="div2">
                <label>État:</label>
                <span> <strong> ${cmd.etat} </strong></span>
            </div>
            <button type="submit" name="action" value="details" style="color: white; background-color: green; width: 100px;">details</button>
            
        </fieldset>
        <br/>
        </form>
    </c:forEach>


</body>
</html>