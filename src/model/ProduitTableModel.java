package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Produit;

public class ProduitTableModel extends AbstractTableModel {
	
	/**
	 * Les colonnes a afficher
	 */
	String[] colonnes=new String[] {"Code", "Designation", "Prix", "Quantite", "T.V.A"};
	
	/**
	 * La liste des produits
	 */
	List<Produit> produits;
	
	@Override
	public String getColumnName(int index) {

		return colonnes[index];
	}
	
	@Override
	public int getColumnCount() {
		
		return colonnes.length;
	}

	@Override
	public int getRowCount() {
		
		return produits.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Produit produit = produits.get(row);
		switch(col) {
			case 0: return produit.getCode();
			case 1: return produit.getDesignation();
			case 2: return produit.getPrix();
			case 3: return produit.getQuantite();
			case 4: return produit.getTva();
		}
		return null;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
