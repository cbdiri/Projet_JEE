<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Articles Admin</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/inc/style.css"></head>	

<body>
    <c:import url="../inc/menu_Admin.jsp" />

<br/>    
    <form action="ProfileAdmin" method="Post">
        <input type="hidden" name="userId" value="${utilisateur.id}" />
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Login</th>
                 <th>Password</th>
                <th>T�l�phone</th>
                <th>Admin</th>
                <th>Action</th>
            </tr>
            <tr>
                <td><input type="text" name="id" value="${usr.id}" readonly /></td>
                <td><input type="text" name="name" value="${usr.name}" /></td>
                <td><input type="text" name="email" value="${usr.email}" /></td>
                <td><input type="text" name="login" value="${usr.login}" /></td>
                <td><input type="text" name="password" value="${usr.password}" /></td>
                <td><input type="text" name="tel" value="${usr.tel}" /></td>
				<td><input type="checkbox" name="admin" ${usr.admin ? 'checked' : ''} /></td>
                <td>
                 <button type="submit" name="action" value="edit" style="color: white; background-color: blue;width: 100px;">Edit</button>
                    
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

