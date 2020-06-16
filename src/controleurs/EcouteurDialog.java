package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Produit;
import vue.Fenetre;

public class EcouteurDialog implements ActionListener{

	Fenetre fenetre;
	
	public EcouteurDialog(Fenetre fenetre) {
		this.fenetre=fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(fenetre.getProduitInterface().getCancelButton())) {
			fenetre.getProduitInterface().setVisible(false);
			if (!fenetre.isAdmin())
			 fenetre.getProduitInterface().getPrixTextField().setVisible(true);
		}
		else if(e.getSource().equals(fenetre.getProduitInterface().getOkButton())) {
			String designation= fenetre.getProduitInterface().getDesignationTextField().getText();
			String prix=fenetre.getProduitInterface().getPrixTextField().getText();
			String quantite=fenetre.getProduitInterface().getQuantiteTextField().getText();
			String tva =fenetre.getProduitInterface().getTvaTextField().getText();

			Produit produit=new Produit(designation,Float.parseFloat(prix),Float.parseFloat(quantite),Integer.parseInt(tva));
			
			if(fenetre.getProduitInterface().getOkButton().getActionCommand().equals("Ajout")) {
				fenetre.getControleurProduit().addProduit(produit);
				fenetre.getProduitTablePanel().setData(fenetre.getControleurProduit().getProduits());
				fenetre.getProduitTablePanel().refresh();
				JOptionPane.showMessageDialog(fenetre, "Le produit a ete ajoute avec succes", "Succes",
						JOptionPane.INFORMATION_MESSAGE);
				fenetre.getProduitInterface().hide();

			}
			else if(fenetre.getProduitInterface().getOkButton().getActionCommand().equals("Modification")) {
				int rowIndex=fenetre.getProduitTablePanel().getTable().getSelectedRow();
				produit=fenetre.getControleurProduit().getProduits().get(rowIndex);
				produit.setDesignation(designation);
				produit.setPrix(Float.parseFloat(prix));
				produit.setQuantite(Float.parseFloat(quantite));
				produit.setTva(Integer.parseInt(tva));
				int respone=JOptionPane.showConfirmDialog(fenetre, "Voulez-vous vraiment modifie le produit en question",
						"Confirmer la modification", JOptionPane.OK_CANCEL_OPTION);
				if(respone==JOptionPane.OK_OPTION) {
					fenetre.getControleurProduit().updateProduit(produit);
					fenetre.getProduitTablePanel().setData(fenetre.getControleurProduit().getProduits());
					fenetre.getProduitTablePanel().refresh();
					JOptionPane.showMessageDialog(fenetre, "Le produit a ete modifie avec succes", "Succes",
							JOptionPane.INFORMATION_MESSAGE);
					fenetre.getProduitInterface().hide();

				}
			}else if(fenetre.getProduitInterface().getOkButton().getActionCommand().equals("Modification1")) {
				int rowIndex=fenetre.getProduitRechercheResultatDialog().getTable().getSelectedRow();
				produit=fenetre.getControleurProduit().getProduits().get(rowIndex);
				produit.setDesignation(designation);
				produit.setPrix(Float.parseFloat(prix));
				produit.setQuantite(Float.parseFloat(quantite));
				produit.setTva(Integer.parseInt(tva));
				int respone=JOptionPane.showConfirmDialog(fenetre, "Voulez-vous vraiment modifie le produit en question",
						"Confirmer la modification", JOptionPane.OK_CANCEL_OPTION);
				if(respone==JOptionPane.OK_OPTION) {
					fenetre.getControleurProduit().updateProduit(produit);
					fenetre.getProduitTablePanel().setData(fenetre.getControleurProduit().getProduits());
					fenetre.getProduitTablePanel().refresh();
					String nomCherche=fenetre.getProduitRechercheDialog().getNomTextField().getText();
					fenetre.getProduitRechercheResultatDialog().setData(fenetre.getControleurProduit().rechercheProduits(nomCherche));
					fenetre.getProduitRechercheResultatDialog().refresh();

					JOptionPane.showMessageDialog(fenetre, "Le produit a ete modifie avec succes", "Succes",
							JOptionPane.INFORMATION_MESSAGE);

					fenetre.getProduitInterface().hide();
				}

			}
		}
		
	}
	
}
