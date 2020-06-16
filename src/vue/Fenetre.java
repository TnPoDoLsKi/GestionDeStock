package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controleurs.*;

public class Fenetre extends JFrame{

	private boolean admin;
	private EntetePanel entetePanel;
	private ProduitTablePanel produitTablePanel;
	private ProduitInterface produitInterface;
	private ProduitRechercheDialog produitRechercheDialog;
	private ProduitRechercheResultatDialog produitRechercheResultatDialog;
	private LoginInterface loginInterface;
	
	private ControleurProduit controleurProduit;
	private EcouteurEntete ecouteurEntete;
	private EcouteurDialog ecouteurDialog;
	private EcouteurTableProduit ecouteurTableProduit;
	private EcouteurDialogRecherche ecouteurDialogRecherche;
	private EcouteurLogin ecouteurLogin;
	
	public Fenetre() {
		
		this.setTitle("Gestion de Stock");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700,400);
		/**
		 * Pour centrer la fenetre dans le screen
		 */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		/**
		 * L'instanciation des panels
		 */
		entetePanel=new EntetePanel();
		produitTablePanel =new ProduitTablePanel(this);
		produitInterface =new ProduitInterface(this);
		produitRechercheDialog =new ProduitRechercheDialog(this);
		produitRechercheResultatDialog=new ProduitRechercheResultatDialog(this);
		
		controleurProduit =new ControleurProduit();
		ecouteurEntete=new EcouteurEntete(this);
		ecouteurDialog=new EcouteurDialog(this);
		ecouteurTableProduit =new EcouteurTableProduit(this);
		ecouteurDialogRecherche=new EcouteurDialogRecherche(this);
		ecouteurLogin = new EcouteurLogin(this);
		loginInterface = new LoginInterface(this);
		
		/**
		 * L'ajout de donnees dans la table
		 */
		produitTablePanel.setData(controleurProduit.getProduits());
		
		produitTablePanel.refresh();
		

		
		/**
		 * Les evenements
		 */
		entetePanel.getExitItem().addActionListener(ecouteurEntete);
		entetePanel.getAjouterProduitItem().addActionListener(ecouteurEntete);
		entetePanel.getChercherProduitItem().addActionListener(ecouteurEntete);

		produitInterface.getCancelButton().addActionListener(ecouteurDialog);
		produitInterface.getOkButton().addActionListener(ecouteurDialog);

		produitTablePanel.getModifierButton().addActionListener(ecouteurTableProduit);
		produitTablePanel.getDeleteButton().addActionListener(ecouteurTableProduit);

		produitRechercheDialog.getRechercherButton().addActionListener(ecouteurDialogRecherche);

		produitRechercheResultatDialog.getModifierButton().addActionListener(ecouteurDialogRecherche);
		produitRechercheResultatDialog.getDeleteButton().addActionListener(ecouteurDialogRecherche);

		loginInterface.getLoginButton().addActionListener(ecouteurLogin);
		loginInterface.getCancelButton().addActionListener(ecouteurLogin);


		/**
		 * Le layout manager de la fenetre
		 */
		this.setLayout(new BorderLayout());
		
		/**
		 */
		/**
		 * L'ajout des panels dans le layout principale
		 */
		this.add(entetePanel, BorderLayout.NORTH);
		this.add(produitTablePanel, BorderLayout.CENTER);
		
		/**
		 * Rendre la fenetre visible
		 */
		loginInterface.setVisible(true);

	}

	public EntetePanel getEntetePanel() {
		return entetePanel;
	}

	public ProduitTablePanel getProduitTablePanel() {
		return produitTablePanel;
	}

	public ProduitInterface getProduitInterface() {
		return produitInterface;
	}

	public ProduitRechercheDialog getProduitRechercheDialog() {
		return produitRechercheDialog;
	}

	public ProduitRechercheResultatDialog getProduitRechercheResultatDialog() {
		return produitRechercheResultatDialog;
	}

	public ControleurProduit getControleurProduit() {
		return controleurProduit;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public LoginInterface getLoginInterface() {
		return loginInterface;
	}
}
