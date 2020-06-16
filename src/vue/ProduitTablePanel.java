package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import model.Produit;
import model.ProduitTableModel;

public class ProduitTablePanel extends JPanel{
	
	private JTable table;
	private ProduitTableModel produitTableModel;
	
	private JButton modifierButton;
	private JButton deleteButton;
	
	private JPanel buttonsPanel;
	
	public ProduitTablePanel(Fenetre fenetre) {
		/**
		 * Specification de la taille du panel
		 */
		Dimension dimension=getPreferredSize();
		dimension.width=350;
		setPreferredSize(dimension);
		dimension.width=250;
		setMinimumSize(dimension);
		
		/**
		 * L'ajout du model dans la table
		 */
		table=new JTable();
		produitTableModel =new ProduitTableModel();
		table.setModel(produitTableModel);
		
		modifierButton=new JButton("Modifier");
		deleteButton=new JButton("Supprimer");
		
		/**
		 * Buttons Panel
		 */
		buttonsPanel=new JPanel();
		
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		buttonsPanel.add(modifierButton);
		buttonsPanel.add(deleteButton);

		
		/**
		 * Pour centrer les informations
		 */
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( DefaultTableCellRenderer.CENTER );
		table.setDefaultRenderer(Object.class, centerRenderer);
		
		/**
		 * Le layout manager du panel
		 */
		setLayout(new BorderLayout());
		/**
		 * L'ajout de la table dans le panel
		 */
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	public void setData(List<Produit> produits) {
		produitTableModel.setProduits(produits);
	}

	public void refresh() {
		produitTableModel.fireTableDataChanged();
	}

	public JTable getTable() {
		return table;
	}

	public ProduitTableModel getProduitTableModel() {
		return produitTableModel;
	}

	public JButton getModifierButton() {
		return modifierButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

}
