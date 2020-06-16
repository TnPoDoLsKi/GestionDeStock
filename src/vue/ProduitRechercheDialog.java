package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ProduitRechercheDialog extends JDialog{
	
	private JLabel nomLabel;
	private JTextField nomTextField;
	private JButton rechercherButton;
	
	public ProduitRechercheDialog(JFrame parent) {
		super(parent, "Recherche", false);
		
		nomLabel=new JLabel("Nom Cherche");

		
		nomTextField=new JTextField(15);

		
		rechercherButton=new JButton("Chercher");
		
		setLayout(new GridBagLayout());
		
		layoutControls();
		
		setSize(700, 200);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	private void layoutControls() {
		JPanel controlsPannel=new JPanel();
		int space=15;
		Border titleBorder=BorderFactory.createTitledBorder("Rechercher");
		Border spaceBorder=BorderFactory.createEmptyBorder(space, space, space, space);
		
		/**
		 * Controls layout
		 */
		controlsPannel.setLayout(new GridBagLayout());
		controlsPannel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		
		GridBagConstraints gc=new GridBagConstraints();
		Insets rightPadding=new Insets(0, 0, 0, 5);
		Insets noPadding=new Insets(0, 0, 0, 0);
		
		gc.fill=GridBagConstraints.NONE;
		/**
		 * First row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy=0;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(nomLabel, gc);
		
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=rightPadding;
		controlsPannel.add(nomTextField, gc);



		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(rechercherButton, gc);



		setLayout(new BorderLayout());
		add(controlsPannel, BorderLayout.CENTER);
	}

	public JTextField getNomTextField() {
		return nomTextField;
	}



	public JButton getRechercherButton() {
		return rechercherButton;
	}
	
}
