package model;

public class Produit {

	int code;
	String designation;
	float prix;
	float Quantite;
	int tva;
	
	public Produit() {
	}

	public Produit(int code, String designation, float prix, float quantite, int tva) {
		this.code = code;
		this.designation = designation;
		this.prix = prix;
		Quantite = quantite;
		this.tva = tva;
	}

	public Produit(String designation, float prix, float quantite, int tva) {
		this.designation = designation;
		this.prix = prix;
		Quantite = quantite;
		this.tva = tva;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public float getQuantite() {
		return Quantite;
	}

	public void setQuantite(float quantite) {
		Quantite = quantite;
	}

	public int getTva() {
		return tva;
	}

	public void setTva(int tva) {
		this.tva = tva;
	}
}
