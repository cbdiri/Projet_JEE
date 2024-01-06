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

import com.Ecommerce.Beans.Commande;
import com.Ecommerce.Beans.Commande_Produit;
import com.Ecommerce.DAO.DAO;

public class DetailsCMD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DetailsCMD() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id_cmd = Integer.parseInt(request.getParameter("commande_id"));
		
		ArrayList<Commande_Produit> Commande_Produits = new ArrayList<>();

		 Connection connection = DAO.getConnection();
		 String sql =" SELECT * FROM Commande_Produit WHERE id_Commande = ?";
		 
		 try (PreparedStatement statement = connection.prepareStatement(sql)){
			  
			  statement.setInt(1, id_cmd);

			 try( ResultSet resultSet = statement.executeQuery()){
		
	
				 while (resultSet.next()) {
					 Commande_Produit cp = new Commande_Produit();

					 cp.setId(resultSet.getInt("id"));
					 cp.setId_Commande(resultSet.getInt("id_Commande"));
					 cp.setId_produit(resultSet.getInt("id_produit"));
					 cp.setQuantite(resultSet.getInt("quantite"));
					 cp.setPrix_unitaire(resultSet.getDouble("prix_unitaire"));
					 cp.setMontant_total(resultSet.getDouble("montant_total"));
		
					 System.out.println(cp.getPrix_unitaire());
					 Commande_Produits.add(cp);

	               }
			 }
			 
    }catch (SQLException e) {
		
		e.printStackTrace();
	}
		 request.setAttribute("CP", Commande_Produits);
		 
		 

		this.getServletContext().getRequestDispatcher("/User/Commande_Produit.jsp").forward(request, response);		
		
		
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
