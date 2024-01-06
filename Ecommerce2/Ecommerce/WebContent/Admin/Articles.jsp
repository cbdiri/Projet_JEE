<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Articles Admin</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/inc/style.css"></head>	
<style>
  select {
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        width: 100%;
    }
</style>
</head>
<body>
    <c:import url="../inc/menu_Admin.jsp" />
   <br/>

	<form action="./ArticlesAdmin" method="post">
    <fieldset>
        <legend>Ajouter Catégorie</legend>

        <label>Nom de la Catégorie:</label>
        <input type="text" name="name" required	><br>

        <input type="submit" name="action" value="AjouterCategorie">
    </fieldset>
    <p style="color: green;"  >${Message}</p>
</form>
<br/>
<form action="./ArticlesAdmin" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>Ajouter Articles</legend>

        <label>Nom du Produit:</label>
        <input type="text" name="name" required><br>

        <label>Prix du Produit:</label>
		<input type="number" name="prix" min="0" step="0.01" required><br>
        <label>Photo Produit:</label>
	<input type="file" id="photo" name="photo" >
      
        <label>Catégorie du Produit:</label>
        
		  <select name="categorie_id">
		    <c:forEach var="cat" items="${cats}">
		        <option value="${cat.id}">${cat.name}</option>
		    </c:forEach>
		</select>
        <br><br/>

        <input type="submit"  name="action" value="AjouterArticle">
    </fieldset>
        <p style="color: green;"  >${Message}</p>
    
</form>


 
</body>
</html>