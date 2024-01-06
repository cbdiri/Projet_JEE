package com.Ecommerce.ServletsAdmin;

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

import com.Ecommerce.Beans.Utilisateur;
import com.Ecommerce.DAO.DAO;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class UtilisateursAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UtilisateursAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	    ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
		
	    Connection connection = DAO.getConnection();
		String sql = "SELECT *  FROM utilisateur ";
		
	    try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                	
                	Utilisateur utilisateur = new Utilisateur();
                	utilisateur.setId(resultSet.getInt("id"));
                    utilisateur.setName(resultSet.getString("name"));
                    utilisateur.setEmail(resultSet.getString("email"));
                    utilisateur.setLogin(resultSet.getString("login"));
                    utilisateur.setPassword(resultSet.getString("Password"));
                    utilisateur.setTel(resultSet.getString("tel"));
                    utilisateur.setAdmin(resultSet.getBoolean("admin"));


                    utilisateurs.add(utilisateur);
               }
           } catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	          
	 request.setAttribute("utilisateurs", utilisateurs);

	this.getServletContext().getRequestDispatcher("/Admin/Utilisateurs.jsp").forward(request, response);
		 

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
	    String action = request.getParameter("action");

	
		int userId = Integer.parseInt(id);
	   
			Connection connection = DAO.getConnection();
			

		    if ("delete".equals(action)) {
		    	

		    	String sql = "DELETE FROM utilisateur WHERE id = ?";
				
			    try (PreparedStatement statement = connection.prepareStatement(sql);) {

			          statement.setInt(1, userId);

			           statement.executeUpdate();;
			    	
			    	
		           } catch (SQLException e) {
					
					e.printStackTrace();
				}
			    
		    
		    } else if ("edit".equals(action)) {
		      
		    	String name = request.getParameter("name");
		        String email = request.getParameter("email");
		        String login = request.getParameter("login");
		        String password = request.getParameter("password");
		        String tel = request.getParameter("tel");
		        boolean admin = request.getParameter("admin") != null;		        
		     
		        
		        String sql= "UPDATE utilisateur SET name=?, email=?, login=?, password=? ,tel=?, admin=? WHERE id=?";
		        
		        try (PreparedStatement statement = connection.prepareStatement(sql);) {

			          statement.setString(1, name);
			          statement.setString(2, email);
			          statement.setString(3, login);
			          statement.setString(4, password);
			          statement.setString(5, tel);
			          statement.setBoolean(6, admin);
			          statement.setInt(7, userId);
			          statement.executeUpdate();
			    	
			    	
		           } catch (SQLException e) {
					
					e.printStackTrace();
				}
			    
		    }
	
	
		    response.sendRedirect(request.getContextPath() + "/UtilisateursAdmin");
 
	}
	

}
