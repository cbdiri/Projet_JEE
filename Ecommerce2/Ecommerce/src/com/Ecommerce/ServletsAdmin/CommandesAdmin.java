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

import com.Ecommerce.Beans.Commande;
import com.Ecommerce.DAO.DAO;


public class CommandesAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CommandesAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		ArrayList<Commande> Commandes = new ArrayList<>();

		 Connection connection = DAO.getConnection();
		 String sql =" SELECT * FROM Commande ";
		 
		 try (PreparedStatement statement = connection.prepareStatement(sql)){
			  

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

		this.getServletContext().getRequestDispatcher("/Admin/Commandes.jsp").forward(request, response);
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("commande_id"));
		
		 Connection connection = DAO.getConnection();
		 String sql ="UPDATE Commande SET etat = 'confirmé' WHERE id = ? ";
		 try (PreparedStatement statement = connection.prepareStatement(sql);) {


		        statement.setInt(1, id);
		        statement.executeUpdate();
		  				    	
		     } catch (SQLException e) {
				
				e.printStackTrace();
			}
	doGet(request, response);
	}

}
