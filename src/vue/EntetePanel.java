package vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class EntetePanel extends JPanel{
	
	private JMenuBar menuBar;
	private JMenu fileMenu, contactMenu;
	private JMenuItem exitItem, ajouterContactItem, chercherContactItem;
	
	
	public EntetePanel() {
		
		setLayout(new BorderLayout());
		
		menuBar=new JMenuBar();
		
		fileMenu=new JMenu("Fichier");
		contactMenu=new JMenu("Produit");
		
		exitItem=new JMenuItem("Quitter");
		ajouterContactItem=new JMenuItem("Ajouter Produit");
		chercherContactItem=new JMenuItem("Chercher Produit");
		
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		ajouterContactItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		chercherContactItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		
		fileMenu.add(exitItem);
		contactMenu.add(ajouterContactItem);
		contactMenu.add(chercherContactItem);
		
		menuBar.add(fileMenu);
		menuBar.add(contactMenu);
		
		this.add(menuBar, BorderLayout.NORTH);
	}


	public JMenuItem getExitItem() {
		return exitItem;
	}

	public JMenuItem getAjouterProduitItem() {
		return ajouterContactItem;
	}

	public JMenuItem getChercherProduitItem() {
		return chercherContactItem;
	}

}
