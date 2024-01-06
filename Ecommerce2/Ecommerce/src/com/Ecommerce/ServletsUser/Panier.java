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

import com.Ecommerce.Beans.Panier_Produit;
import com.Ecommerce.Beans.Produit;
import com.Ecommerce.DAO.DAO;


public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Panier() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<Panier_Produit> Panier_Produits = new ArrayList<>();
		ArrayList<Produit> Produits = new ArrayList<>();
		
		HttpSession session = request.getSession();
		int id_panier = (int)session.getAttribute("iduser");

	    Connection connection = DAO.getConnection();
	    
	    String sql = "SELECT Produit.id,path_photo,name,Panier_Produit.id, quantite, prix_unitaire, montant_total FROM Panier_Produit JOIN Produit ON Panier_Produit.id_produit = Produit.id WHERE id_panier = ?";    
		
	    try (PreparedStatement statement = connection.prepareStatement(sql)){
			  
			  statement.setInt(1, id_panier);

			 try( ResultSet resultSet = statement.executeQuery()){
		
	
				 while (resultSet.next()) {
	                	
	                	Produit pd = new Produit();
	                	Panier_Produit pp = new Panier_Produit();
	                	
	                	pd.setPath_photo( resultSet.getString("path_photo"));
	                	pd.setName(resultSet.getString("name"));
	                	
	                	
	                	pp.setId(resultSet.getInt("Panier_Produit.id"));
	                	pp.setId_produit(resultSet.getInt("Produit.id"));
	                	pp.setQuantite(resultSet.getInt("quantite"));
	                	pp.setPrix_unitaire(resultSet.getDouble("prix_unitaire"));
	                	pp.setMontant_total(resultSet.getDouble("montant_total"));
	                          	
	              


	                    Produits.add(pd);
	                    Panier_Produits.add(pp);
	               }
	   
			 }
			 
      }catch (SQLException e) {
		
		e.printStackTrace();
	}
		
	
	    
	 request.setAttribute("produits", Produits);
	 request.setAttribute("Panier_Produits", Panier_Produits);

	 session.setAttribute("produits", Produits); 
	 session.setAttribute("Panier_Produits", Panier_Produits); 

	this.getServletContext().getRequestDispatcher("/User/Panier.jsp").forward(request, response);		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int Panier_Produit_id = Integer.parseInt(request.getParameter("Panier_Produit"));
	
		Connection connection = DAO.getConnection();

		if(request.getParameter("action").equals("delete")){
			
			System.out.println("delete");
			String sql = "DELETE FROM Panier_Produit WHERE id = ?";
			
		    try (PreparedStatement statement = connection.prepareStatement(sql);) {

		          statement.setInt(1, Panier_Produit_id);

		           statement.executeUpdate();;
		    	
		    	
	           } catch (SQLException e) {
				
				e.printStackTrace();
			}

		    doGet(request, response);
			
		}else if (request.getParameter("action").equals("edit")){
			int qte = Integer.parseInt(request.getParameter("qte"));
			double prix_unitaire = Double.parseDouble(request.getParameter("prix_unitaire"));
			double montant_total = prix_unitaire*qte;
			
			  String sql= "UPDATE Panier_Produit SET quantite=?,montant_total=?  WHERE id=?";
		        try (PreparedStatement statement = connection.prepareStatement(sql);) {


			          statement.setInt(1,qte);
			          statement.setDouble(2,montant_total );
			          statement.setInt(3,Panier_Produit_id);

			          statement.executeUpdate();
			    	
		           } catch (SQLException e) {
					
					e.printStackTrace();
				}
		        
			    doGet(request, response);
			
		}
		
		
		
		
	}

}
