package com.Ecommerce.Beans;

public class Utilisateur {
	
	private int id;
	private String name;
	private String email;
	private String login;
	private String password;
	private String tel;
	private Boolean admin;
	
	public Utilisateur(){
		super();
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
