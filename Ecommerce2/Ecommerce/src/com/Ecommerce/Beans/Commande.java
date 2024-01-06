package com.Ecommerce.Beans;

import java.sql.Date;

public class Commande {

	
	private int id;
	private Date date_commande;
	private double Montant_commande ;
	private int id_utilisateur;
	private String etat ;
	
	
	public Commande(){
		super();
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate_commande() {
		return date_commande;
	}


	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}


	public double getMontant_commande() {
		return Montant_commande;
	}


	public void setMontant_commande(double montant_commande) {
		Montant_commande = montant_commande;
	}


	public int getId_utilisateur() {
		return id_utilisateur;
	}


	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}



	
	
}
