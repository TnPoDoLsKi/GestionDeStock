package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ProduitInterface extends JDialog{
	
	private JLabel designationLabel, prixLabel, quantiteLabel,tvaLabel;
	private JTextField designationTextField, prixTextField , quantiteTextField,tvaTextField ;
	private JButton okButton, cancelButton;
	
	public ProduitInterface(JFrame parent) {
		super(parent, "Produit", false);
		
		designationLabel=new JLabel("Designation");
		prixLabel=new JLabel("Prix");
		quantiteLabel=new JLabel("Quantite");
		tvaLabel=new JLabel("Tva");


		designationTextField=new JTextField(15);
		prixTextField=new JTextField(15);
		quantiteTextField=new JTextField(15);
		tvaTextField=new JTextField(15);


		
		okButton=new JButton("Ok");
		cancelButton=new JButton("Cancel");
		
		setLayout(new GridBagLayout());
		
		layoutControls();
        
		
		setSize(400, 400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setUndecorated(true);
	}
	
	private void layoutControls() {
		JPanel controlsPannel=new JPanel();
		JPanel buttonsPanel=new JPanel();
		
		int space=15;
		Border titleBorder=BorderFactory.createTitledBorder("Ajouter un produit");
		Border spaceBorder=BorderFactory.createEmptyBorder(space, space, space, space);
		
		/**
		 * Controls layout
		 */
		controlsPannel.setLayout(new GridBagLayout());
		controlsPannel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		
		/**
		 * Buttons layout
		 */
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		GridBagConstraints gc=new GridBagConstraints();
		Insets rightPadding=new Insets(0, 0, 0, 15);
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
		controlsPannel.add(designationLabel, gc);
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(designationTextField, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(prixLabel, gc);
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(prixTextField, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		
		gc.gridy++;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(quantiteLabel, gc);
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(quantiteTextField, gc);



		gc.weightx=1;
		gc.weighty=1;

		gc.gridy++;

		gc.gridx=0;
		gc.anchor=GridBagConstraints.EAST;
		gc.insets=rightPadding;
		controlsPannel.add(tvaLabel, gc);
		gc.gridx++;
		gc.anchor=GridBagConstraints.WEST;
		gc.insets=noPadding;
		controlsPannel.add(tvaTextField, gc);
		
		/**
		 * Next row
		 */
		gc.weightx=1;
		gc.weighty=1;
		gc.gridy++;
		
		gc.gridx=0;
		buttonsPanel.add(okButton, gc);
		gc.gridx++;
		buttonsPanel.add(cancelButton, gc);
		
		setLayout(new BorderLayout());
		add(controlsPannel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	public JTextField getDesignationTextField() {
		return designationTextField;
	}

	public JTextField getPrixTextField() {
		return prixTextField;
	}

	public JTextField getQuantiteTextField() {
		return quantiteTextField;
	}

	public JTextField getTvaTextField() {
		return tvaTextField;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
}
