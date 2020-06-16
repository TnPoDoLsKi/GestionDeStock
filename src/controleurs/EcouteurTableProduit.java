package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Produit;
import vue.Fenetre;

public class EcouteurTableProduit implements ActionListener{
	
	Fenetre fenetre;
	
	public EcouteurTableProduit(Fenetre fenetre) {
		this.fenetre=fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rowIndex=fenetre.getProduitTablePanel().getTable().getSelectedRow();
		if(rowIndex==-1) {
			// message d'erreur
		}
		else {
			Produit produit=fenetre.getControleurProduit().getProduits().get(rowIndex);
			
			if(e.getSource().equals(fenetre.getProduitTablePanel().getDeleteButton())) {
				int respone=JOptionPane.showConfirmDialog(fenetre, "Voulez-vous vraiment supprime le produit ",
						"Confirmer la modification", JOptionPane.OK_CANCEL_OPTION);
				if(respone==JOptionPane.OK_OPTION) {
					fenetre.getControleurProduit().deleteProduit(produit.getCode());
					fenetre.getProduitTablePanel().setData(fenetre.getControleurProduit().getProduits());
					fenetre.getProduitTablePanel().refresh();
					JOptionPane.showMessageDialog(fenetre, "Le produit a ete supprime avec succes", "Succes",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource().equals(fenetre.getProduitTablePanel().getModifierButton())) {
				fenetre.getProduitInterface().getDesignationTextField().setText(produit.getDesignation());
				fenetre.getProduitInterface().getPrixTextField().setText(String.valueOf(produit.getPrix()));
				fenetre.getProduitInterface().getOkButton().setText("Modifier");
				fenetre.getProduitInterface().getOkButton().setActionCommand("Modification");
				fenetre.getProduitInterface().setVisible(true);
				if (!fenetre.isAdmin())
					fenetre.getProduitInterface().getPrixTextField().hide();

			}
		}
	}
}
