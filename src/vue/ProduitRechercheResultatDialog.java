package vue;

import model.Produit;
import model.ProduitTableModel;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class ProduitRechercheResultatDialog extends JDialog{

	private JTable table;
	private ProduitTableModel produitTableModel;

	private JButton modifierButton;
	private JButton deleteButton;

	private JPanel buttonsPanel;

	public ProduitRechercheResultatDialog(JFrame parent) {
		/**
		 * Specification de la taille du panel
		 */
		Dimension dimension = getPreferredSize();
		dimension.width = 350;
		setPreferredSize(dimension);
		dimension.width = 250;
		setMinimumSize(dimension);

		/**
		 * L'ajout du model dans la table
		 */
		table = new JTable();
		produitTableModel = new ProduitTableModel();
		table.setModel(produitTableModel);

		modifierButton = new JButton("Modifier");
		deleteButton = new JButton("Supprimer");

		/**
		 * Buttons Panel
		 */
		buttonsPanel = new JPanel();

		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		buttonsPanel.add(modifierButton);
		buttonsPanel.add(deleteButton);

		/**
		 * Pour centrer les informations
		 */
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
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

		setSize(700, 200);

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
