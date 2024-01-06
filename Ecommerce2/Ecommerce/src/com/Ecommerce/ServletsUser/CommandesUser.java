package com.Ecommerce.ServletsUser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ecommerce.Beans.Commande;
import com.Ecommerce.Beans.Panier_Produit;
import com.Ecommerce.Beans.Produit;
import com.Ecommerce.DAO.DAO;



public class CommandesUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
    public CommandesUser() {
        super();

    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int iduser = (int)session.getAttribute("iduser");
		
		ArrayList<Commande> Commandes = new ArrayList<>();

		 Connection connection = DAO.getConnection();
		 String sql =" SELECT * FROM Commande WHERE id_utilisateur = ?";
		 
		 try (PreparedStatement statement = connection.prepareStatement(sql)){
			  
			  statement.setInt(1, iduser);

			 try( ResultSet resultSet = statement.executeQuery()){
		
	
				 while (resultSet.next()) {
					 Commande cmd = new Commande();

					 cmd.setId(resultSet.getInt("id"));
					 cmd.setDate_commande(resultSet.getDate("date_commande"));
					 cmd.setMontant_commande(resultSet.getDouble("Montant_commande"));
					 cmd.setId_utilisateur(resultSet.getInt("id_utilisateur"));	
	                 cmd.setEtat(resultSet.getString("etat"));
	
					 	Commandes.add(cmd);

	               }
			 }
			 
     }catch (SQLException e) {
		
		e.printStackTrace();
	}
		 request.setAttribute("cmd", Commandes);

		this.getServletContext().getRequestDispatcher("/User/Commandes.jsp").forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int id_user = (int)session.getAttribute("iduser");
		double Montant_commande = Double.parseDouble(request.getParameter("Montant_commande"));

		
	

	Connection connection = DAO.getConnection();
	String sql = "INSERT INTO Commande (date_commande,Montant_commande,id_utilisateur) VALUES (CURDATE(),?,?) ";

	try (PreparedStatement statement = connection.prepareStatement(sql);) {


        statement.setDouble(1, Montant_commande);
        statement.setInt(2, id_user);
        
        statement.executeUpdate();
  				    	
     } catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	// Récupérer la liste de produits de la session
			ArrayList<Produit> produits = (ArrayList<Produit>) session.getAttribute("produits");
			ArrayList<Panier_Produit> Panier_Produits = (ArrayList<Panier_Produit>) session.getAttribute("Panier_Produits");

			for (Panier_Produit pp : Panier_Produits) {
				System.out.println(pp.getId_produit());
				System.out.println(pp.getQuantite());
				System.out.println(pp.getPrix_unitaire());
				System.out.println( pp.getMontant_total());
				System.out.println();
			    String sql2 = "INSERT INTO Commande_Produit (id_Commande, id_produit, quantite, prix_unitaire, montant_total) " +
			                  "VALUES ((SELECT MAX(id) FROM Commande), ?, ?, ?, ?)";

			    try (PreparedStatement statement = connection.prepareStatement(sql2)) {
			        statement.setInt(1, pp.getId_produit());
			        statement.setInt(2, pp.getQuantite());
			        statement.setDouble(3, pp.getPrix_unitaire());
			        statement.setDouble(4, pp.getMontant_total());

			        statement.executeUpdate();
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
			
			 String sql3 = "DELETE FROM Panier_Produit WHERE id_panier = ?";
				
			    try (PreparedStatement statement = connection.prepareStatement(sql3);) {

			          statement.setInt(1, id_user);

			           statement.executeUpdate();;
			    	
			    	
		           } catch (SQLException e) {
					
					e.printStackTrace();
				}
	
		doGet(request, response);
	}

}
