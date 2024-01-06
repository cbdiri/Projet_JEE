package com.Ecommerce.ServletsAdmin;
import org.omg.CORBA.portable.InputStream;

import com.Ecommerce.Beans.Categorie;
import com.Ecommerce.Beans.Utilisateur;
import com.Ecommerce.DAO.DAO;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@MultipartConfig(
        fileSizeThreshold = 1024 * 10,  // 10 KB
        maxFileSize = 1024 * 300,       // 300 KB
        maxRequestSize = 1024 * 1024    // 1 MB 
)
public class ArticlesAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ArticlesAdmin() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	 Connection connection = DAO.getConnection();
 		String sql = "SELECT *  FROM Categorie ";
 		 ArrayList<Categorie> cats = new ArrayList<>();
 		 try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                 while (resultSet.next()) {
                 	
                	 Categorie cat = new Categorie();
                	 cat.setId(resultSet.getInt("id"));
                	 cat.setName(resultSet.getString("name"));
                	 cats.add(cat);
                }
            } catch (SQLException e) {
 			
 			e.printStackTrace();
 		}
 		 request.setAttribute("cats", cats);

 		this.getServletContext().getRequestDispatcher("/Admin/Articles.jsp").forward(request, response);
 		
		
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		Connection connection = DAO.getConnection();
		
		if (action.equals("AjouterCategorie")) {
				
				String name = request.getParameter("name");
			   
				String sql = "INSERT INTO Categorie (name) VALUES (?) ";
			  
		        try (PreparedStatement statement = connection.prepareStatement(sql);) {

			          statement.setString(1, name);
			          statement.executeUpdate();
			    				    	
		           } catch (SQLException e) {
					
					e.printStackTrace();
				}
		        
		     
		        request.setAttribute("Message", "Catégorie Ajoué aavec succès ");
		        doGet(request, response);
		 		//this.getServletContext().getRequestDispatcher("/Admin/Articles.jsp").forward(request, response);

		    }  if (action.equals("AjouterArticle")) {

				String name = request.getParameter("name");
				double prix = Double.parseDouble(request.getParameter("prix"));
				int categorie_id = Integer.parseInt(request.getParameter("categorie_id"));
			
	
				    
				    Part filePart = request.getPart("photo");
			        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			        String uploadDirPath = "C:\\Users\\bdiri\\OneDrive\\Bureau\\Ecommerce2\\Ecommerce\\WebContent\\Images";
			 		Path uploadDir = Paths.get(uploadDirPath);
			        Path filePath = uploadDir.resolve(fileName);
			        Files.copy(filePart.getInputStream(), filePath,StandardCopyOption.REPLACE_EXISTING);
			        String path_photo = uploadDir + "/" + fileName;			        
				   
				    
			
	            
				String sql = "INSERT INTO Produit (name,prix,path_photo,categorie_id) VALUES (?,?,?,?) ";
				   try (PreparedStatement statement = connection.prepareStatement(sql);) {
						
				          statement.setString(1, name);
				          statement.setDouble(2,	 prix);
				          statement.setString(3, path_photo);
				          statement.setInt(4, categorie_id);
				          
				          statement.executeUpdate();
				    				    	
			           } catch (SQLException e) {
						
						e.printStackTrace();
					}
			        

		        request.setAttribute("Message", "Produit Ajoué aavec succès ");
		        doGet(request, response);
		    	

		    }
			

	}

 
    
    
    
    
}
