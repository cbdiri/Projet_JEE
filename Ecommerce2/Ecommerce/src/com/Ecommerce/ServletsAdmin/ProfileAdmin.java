package com.Ecommerce.ServletsAdmin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ecommerce.Beans.Utilisateur;
import com.Ecommerce.DAO.DAO;


public class ProfileAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProfileAdmin() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session = request.getSession();
		int id = (int)session.getAttribute("iduser");
		
	    
		Utilisateur usr = new Utilisateur();
		

			Connection connection = DAO.getConnection();
			String sql = "SELECT * FROM utilisateur where id=? ";
			
		  try (PreparedStatement statement = connection.prepareStatement(sql)){
				  
				  statement.setInt(1, id);

				 try( ResultSet resultSet = statement.executeQuery()){
			
		
					 resultSet.next();
			    usr.setId(resultSet.getInt("id"));
	            usr.setName(resultSet.getString("name"));
	            usr.setEmail(resultSet.getString("email"));
	            usr.setLogin(resultSet.getString("login"));
	            usr.setPassword(resultSet.getString("password"));
	            usr.setTel(resultSet.getString("tel"));
	            usr.setAdmin(resultSet.getBoolean("admin"));
		   
				 }
				 
            }catch (SQLException e) {
			
			e.printStackTrace();
		}
		  request.setAttribute("usr", usr);
		  System.out.println(usr.getId());
		  System.out.println(usr.getName());

		  System.out.println(usr.getEmail());

		  System.out.println(usr.getLogin());

		  System.out.println(usr.getPassword());
		  System.out.println(usr.getTel());


		System.out.println(" je suis dans la servelts Home admin ");	
		this.getServletContext().getRequestDispatcher("/Admin/Profile.jsp").forward(request, response);
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = DAO.getConnection();

		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);
		
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        boolean admin = request.getParameter("admin") != null;		        
     
        
        System.out.println(name);
        System.out.println(email);
        System.out.println(login);
        System.out.println(tel);
        System.out.println(admin);
        
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
      
        response.sendRedirect(request.getContextPath() + "/ProfileAdmin");

    }


	}


