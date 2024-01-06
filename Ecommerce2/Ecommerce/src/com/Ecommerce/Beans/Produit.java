package com.Ecommerce.Beans;

public class Produit  {

	   private int id;

	    private String name;
	    private double prix;
	    private String path_photo;
	    private int categorie_id;
	    
	    public Produit(){
	    	super();
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrix() {
			return prix;
		}

		public void setPrix(double string) {
			this.prix = string;
		}

		public String getPath_photo() {
			return path_photo;
		}

		public void setPath_photo(String path_photo) {
			this.path_photo = path_photo;
		}

		public int getCategorie_id() {
			return categorie_id;
		}

		public void setCategorie_id(int string) {
			this.categorie_id = string;
		}

		/*public Categorie getCategorie() {
			return categorie;
		}

		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		}*/
	    
	    
}
