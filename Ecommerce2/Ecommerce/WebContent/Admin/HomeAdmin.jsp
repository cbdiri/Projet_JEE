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
	<c:import url="../inc/menu_Admin.jsp" />

<c:forEach var="pd" items="${produits}">
    <form action="HomeA" method="Post">
        <input type="hidden" name="produit_id" value="${pd.id}" />

        <div class="div2">
         <table>
         <td>
         	<img src="${pd.path_photo}" name="path_photo" alt="Image" style="width: 170px; height: 200px;"/>    
         <td>
          <td>  
            <input type="text" name="name" value="${pd.name}" />
	       
	       
	    	
	    	<input type="text" name="prix" value="${pd.prix}" />
			
              
            <button type="submit" name="action" value="delete" style="color: white; background-color: red; width: 100px;">Delete</button>
            <button type="submit" name="action" value="edit" style="color: white; background-color: blue; width: 100px;">Edit</button>
     </td>
      </table>
        </div>
        
    </form>
    <br/>
</c:forEach>

 

</body>
</html>