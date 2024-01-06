package com.Ecommerce.ServletsUser;

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

import com.Ecommerce.Beans.Produit;
import com.Ecommerce.DAO.DAO;


public class HomeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public HomeUser() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

	this.getServletContext().getRequestDispatcher("/User/HomeUser.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int iduser = (int)session.getAttribute("iduser");
		int produit_id = Integer.parseInt(request.getParameter("produit_id"));
		int quantite = Integer.parseInt(request.getParameter("qte"));
		double prix_unitaire = Double.parseDouble(request.getParameter("prix"));
		double montant_total = prix_unitaire*quantite;
		

		
		System.out.println("id panier "+iduser);
		System.out.println("id_produit "+produit_id);
		System.out.println("prix "+prix_unitaire);
		System.out.println("qutnit " +quantite);

		Connection connection = DAO.getConnection();
        String sql = "INSERT INTO Panier_Produit (id_panier, id_produit, quantite, prix_unitaire, montant_total) VALUES (?, ?, ?, ?, ?)";

		  try (PreparedStatement statement = connection.prepareStatement(sql);) {
	       
			 statement.setInt(1, iduser);
	         statement.setInt(2, produit_id);
	         statement.setInt(3, quantite);
	         statement.setDouble(4, prix_unitaire);
	         statement.setDouble(5, montant_total);

	         statement.executeUpdate();
	    	
           } catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	
	}

}
