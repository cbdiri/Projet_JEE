package com.Ecommerce.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ecommerce.Beans.Panier;
import com.Ecommerce.Beans.Utilisateur;
import com.Ecommerce.DAO.DAO;


public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Auth() {
        super();
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
	 
        Connection connection = DAO.getConnection();
		String sql = "SELECT * FROM utilisateur ";
        
	 try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
        	Utilisateur usr = new Utilisateur();
        	usr.setId(resultSet.getInt("id"));
            usr.setLogin(resultSet.getString("login"));
            usr.setPassword(resultSet.getString("password"));
            usr.setAdmin(resultSet.getBoolean("admin"));
            utilisateurs.add(usr);
        	}
        } catch (SQLException e) {
			e.printStackTrace();
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
	 
	  for (Utilisateur usr : utilisateurs)
	     {
		  
		 	if (login.equals(usr.getLogin()) && password.equals(usr.getPassword()) && usr.getAdmin()== true) {
		         session.setAttribute("ath", "ok");
			     session.setAttribute("iduser",usr.getId());
		         response.sendRedirect("Admin/HomeAdmin.jsp");
		         break;
		     } else if (login.equals(usr.getLogin()) && password.equals(usr.getPassword()) && usr.getAdmin()== false) {
		         session.setAttribute("ath", "ok");
			     session.setAttribute("iduser",usr.getId());


		         response.sendRedirect("User/HomeUser.jsp");
		         break;
		     } 
	     }
	  
	  if(!session.getAttribute("ath"). equals("ok")) {
	         request.setAttribute("errorMessage", "Login ou password incorrect");
	         request.getRequestDispatcher("Login.jsp").forward(request, response);
	     }
   
 }
	
        
        
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = DAO.getConnection();
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        Boolean admin = false;
      
       
        String sql = "INSERT INTO utilisateur (name, email, login, password, tel, admin) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
	          statement.setString(1, name);
	          statement.setString(2, email);
	          statement.setString(3, login);
	          statement.setString(4, password);
	          statement.setString(5, tel);
	          statement.setBoolean(6, admin);

	          statement.executeUpdate();
	    	
           } catch (SQLException e) {
			
			e.printStackTrace();
		}

        
        
        String sql2 = "SELECT MAX(id) AS max_id FROM utilisateur";
        Panier pn = new Panier();
        try (PreparedStatement statement = connection.prepareStatement(sql2)){
			  

			 try( ResultSet resultSet = statement.executeQuery()){
				 
				 	resultSet.next();
			        pn.setId_user(resultSet.getInt("max_id"));
			       
			 }
			 
      }catch (SQLException e) {
		
		e.printStackTrace();
	}
        
        
    String sql3 = "INSERT INTO Panier (id, id_user) VALUES (?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql3);) {
	          
        	statement.setInt(1, pn.getId_user());
        	statement.setInt(2, pn.getId_user());


	          statement.executeUpdate();
	    	
           } catch (SQLException e) {
			
			e.printStackTrace();
		}

        
        
        
       // response.sendRedirect(request.getContextPath() + "/Inscription.jsp");

        request.setAttribute("Message", "Inscription avec succès ");
        request.getRequestDispatcher("Inscription.jsp").forward(request, response);
    }		
		
	

}
