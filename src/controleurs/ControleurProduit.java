package controleurs;

import java.util.LinkedList;

import model.Produit;
import model.User;
import persistance.Requetes;

public class ControleurProduit {
	
	Requetes requetes;
	
	public ControleurProduit() {
		requetes =new Requetes();
	}
	
	public LinkedList<Produit> getProduits(){
		return requetes.getProduits();
	}


	public LinkedList<Produit> rechercheProduits(String designation){
		return requetes.rechercherProduit(designation);
	}

	public User getUser(String password,String email){
		return requetes.getUser(password,email);
	}
	public int addProduit(Produit produit) {
		return requetes.addProduit(produit);
	}
	
	public int deleteProduit(int code) {
		return requetes.deleteProduit(code);
	}
	
	public int updateProduit(Produit produit) {
		return requetes.updateProduit(produit);
	}
}
