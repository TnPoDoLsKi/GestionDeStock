package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Produit;
import vue.Fenetre;

import javax.swing.*;

public class EcouteurDialogRecherche implements ActionListener{

	Fenetre fenetre;
	
	public EcouteurDialogRecherche(Fenetre fenetre) {
		this.fenetre=fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Si on veut chercher(La fenetre principale)
		 */

		if(e.getSource().equals(fenetre.getProduitRechercheDialog().getRechercherButton())) {
			String nomCherche=fenetre.getProduitRechercheDialog().getNomTextField().getText();
			fenetre.getProduitRechercheResultatDialog().setData(fenetre.getControleurProduit().rechercheProduits(nomCherche));
			fenetre.getProduitRechercheResultatDialog().setVisible(true);

		}

		int rowIndex=fenetre.getProduitRechercheResultatDialog().getTable().getSelectedRow();

		if(rowIndex==-1) {
			// message d'erreur
		}
		else {
			Produit produit=fenetre.getControleurProduit().getProduits().get(rowIndex);

			if(e.getSource().equals(fenetre.getProduitRechercheResultatDialog().getDeleteButton())) {
				int respone=JOptionPane.showConfirmDialog(fenetre, "Voulez-vous vraiment supprime le produit ",
						"Confirmer la modification", JOptionPane.OK_CANCEL_OPTION);
				if(respone==JOptionPane.OK_OPTION) {
					fenetre.getControleurProduit().deleteProduit(produit.getCode());
					String nomCherche=fenetre.getProduitRechercheDialog().getNomTextField().getText();
					fenetre.getProduitRechercheResultatDialog().setData(fenetre.getControleurProduit().rechercheProduits(nomCherche));
					fenetre.getProduitRechercheResultatDialog().refresh();


					JOptionPane.showMessageDialog(fenetre, "Le produit a ete supprime avec succes", "Succes",
							JOptionPane.INFORMATION_MESSAGE);

					fenetre.getProduitTablePanel().setData(fenetre.getControleurProduit().getProduits());
					fenetre.getProduitTablePanel().refresh();
				}
			}
			else if(e.getSource().equals(fenetre.getProduitRechercheResultatDialog().getModifierButton())) {
				fenetre.getProduitInterface().getDesignationTextField().setText(produit.getDesignation());
				fenetre.getProduitInterface().getPrixTextField().setText(String.valueOf(produit.getPrix()));
				fenetre.getProduitInterface().getOkButton().setText("Modifier");
				fenetre.getProduitInterface().getOkButton().setActionCommand("Modification1");
				fenetre.getProduitInterface().setVisible(true);
				if (!fenetre.isAdmin())
					fenetre.getProduitInterface().getPrixTextField().hide();
			}
		}

	}
	
	

}
