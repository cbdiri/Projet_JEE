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

import com.Ecommerce.Beans.Produit;
import com.Ecommerce.Beans.Utilisateur;
import com.Ecommerce.DAO.DAO;


public class HomeA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public HomeA() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		System.out.println(" je suis dans la servelts Home admin ");	
	    ArrayList<Produit> Produits = new ArrayList<>();
		
	    Connection connection = DAO.getConnection();
		String sql = "SELECT *  FROM Produit ";
		
	    try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                	
                	Produit pd = new Produit();
                	
                	pd.setId(resultSet.getInt("id"));
                	pd.setName(resultSet.getString("name"));
                	pd.setPrix(resultSet.getDouble("prix"));
                	pd.setPath_photo( resultSet.getString("path_photo"));
                	// pd.setCategorie_id(resultSet.getInt("categorie_id"));             	
        

                    Produits.add(pd);
               }
           } catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	          
	 request.setAttribute("produits", Produits);

	this.getServletContext().getRequestDispatcher("/Admin/HomeAdmin.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("produit_id"));
		
		Connection connection = DAO.getConnection();

		 if ("delete".equals(action)) {
			 
			 String sql = "DELETE FROM Produit WHERE id = ?";
				
			    try (PreparedStatement statement = connection.prepareStatement(sql);) {

			          statement.setInt(1, id);

			           statement.executeUpdate();;
			    	
			    	
		           } catch (SQLException e) {
					
					e.printStackTrace();
				}

			    doGet(request, response);
		 }
		 else if ("edit".equals(action)) {

			 	String name = request.getParameter("name");
			 	double prix = Double.parseDouble(request.getParameter("prix"));

		        String sql= "UPDATE Produit SET name=?, prix=?  WHERE id=?";
		        try (PreparedStatement statement = connection.prepareStatement(sql);) {

			          statement.setString(1, name);
			          statement.setDouble(2, prix);
			          statement.setInt(3,id);
			          statement.executeUpdate();
			    	
			    	
		           } catch (SQLException e) {
					
					e.printStackTrace();
				}
			    doGet(request, response);

		 }
		 
	}

}
