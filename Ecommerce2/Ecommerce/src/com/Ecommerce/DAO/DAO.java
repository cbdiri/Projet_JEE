package com.Ecommerce.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	public static Connection getConnection() {
	      
		System.out.println("i am in onnection getConnection()");
		Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/Ecommerce";
            String username = "root";
            String password = "0000";

            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
	}
	
	public static void listFirstTenPersons() {
		
		System.out.println("i am in listFirstTenPersons ");
        try (Connection connection = getConnection()) {
            // Ensure that the connection is not null
            if (connection != null) {
                String sql = "SELECT id, name, email, login  FROM utilisateur ";

                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {

                    System.out.printf("%s %s %s %s\n", "ID", "Name", "email", "login");
                    System.out.println("---------------------------------------------------");

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        String login = resultSet.getString("login");

                        System.out.printf("%s %s %s %s\n", id, name, email,login);
                    }
                }
            } else {
                System.out.println("Failed to connect to the database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		getConnection();
		listFirstTenPersons();
	}
}

