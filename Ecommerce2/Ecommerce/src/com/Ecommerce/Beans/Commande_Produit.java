package com.Ecommerce.Beans;

public class Commande_Produit {
	
	private int id;
	private int id_Commande;
	private int id_produit;
	private int quantite;
	private double prix_unitaire;
	private double montant_total;

	public Commande_Produit()
	{
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_Commande() {
		return id_Commande;
	}

	public void setId_Commande(int id_Commande) {
		this.id_Commande = id_Commande;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix_unitaire() {
		return prix_unitaire;
	}

	public void setPrix_unitaire(double prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	public double getMontant_total() {
		return montant_total;
	}

	public void setMontant_total(double montant_total) {
		this.montant_total = montant_total;
	}
	
	
}
