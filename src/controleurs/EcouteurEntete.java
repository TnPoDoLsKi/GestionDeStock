package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vue.Fenetre;

public class EcouteurEntete implements ActionListener{

	Fenetre fenetre;
	
	public EcouteurEntete(Fenetre fenetre) {
		this.fenetre=fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(fenetre.getEntetePanel().getExitItem())) {
			int respone=JOptionPane.showConfirmDialog(fenetre.getEntetePanel(), "Voulez-vous vraiment quiter l'application",
					"Confirmer le quit", JOptionPane.OK_CANCEL_OPTION);
			if(respone==JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}
		
		else if(e.getSource().equals(fenetre.getEntetePanel().getAjouterProduitItem())) {
			fenetre.getProduitInterface().getOkButton().setText("Ajouter");
			fenetre.getProduitInterface().getOkButton().setActionCommand("Ajout");
			fenetre.getProduitInterface().setVisible(true);
		}
		else if(e.getSource().equals(fenetre.getEntetePanel().getChercherProduitItem())) {
			fenetre.getProduitRechercheDialog().setVisible(true);
		}
	}

}
