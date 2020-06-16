package persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Produit;
import model.User;

public class Requetes {
	
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rst;
	
	
	public Requetes() {
		try {
			stm=DB.getConection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public LinkedList<Produit> getProduits(){
		
		LinkedList<Produit> produits =new LinkedList<>();
		try{
			String query="SELECT * FROM produit";
			rst=stm.executeQuery(query);
			while(rst.next()) {
				Produit produit =new Produit();
				produit.setCode(rst.getInt("code"));
				produit.setDesignation(rst.getString("designation"));
				produit.setPrix(rst.getFloat("prix"));
				produit.setQuantite(rst.getFloat("quantite"));
				produit.setTva(rst.getInt("tva"));
				produits.add(produit);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return produits;
	}
	



	public int addProduit(Produit produit) {
		try {
			String query="INSERT INTO produit( designation, prix, quantite,tva)"
					+ " VALUES(?, ?, ?, ?)";
			pstm=DB.getConection().prepareStatement(query);
			pstm.setString(1, produit.getDesignation());
			pstm.setFloat(2, produit.getPrix());
			pstm.setFloat(3, produit.getQuantite());
			pstm.setInt(4, produit.getTva());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	

	public int deleteProduit(int code) {
		try{
			String query="DELETE FROM produit WHERE code=?";
			pstm=DB.getConection().prepareStatement(query);
			pstm.setInt(1, code);
			return pstm.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}


	public int updateProduit(Produit produit) {
		try {
			String query="UPDATE produit SET designation=?, prix=?, quantite=?, tva=?"
					+ " WHERE code=?";
			pstm=DB.getConection().prepareStatement(query);
			pstm.setString(1, produit.getDesignation());
			pstm.setFloat(2, produit.getPrix());
			pstm.setFloat(3, produit.getQuantite());
			pstm.setInt(4, produit.getTva());
			pstm.setInt(5, produit.getCode());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public LinkedList<Produit> rechercherProduit(String designation) {
		LinkedList<Produit> produits =new LinkedList<>();
		try{
			String query="SELECT * FROM produit p WHERE p.designation LIKE '%"+designation+"%'";

			rst=stm.executeQuery(query);
			while(rst.next()) {
				Produit produit =new Produit();
				produit.setCode(rst.getInt("code"));
				produit.setDesignation(rst.getString("designation"));
				produit.setPrix(rst.getFloat("prix"));
				produit.setQuantite(rst.getFloat("quantite"));
				produit.setTva(rst.getInt("tva"));
				produits.add(produit);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return produits;

	}

	public User getUser(String password , String email){

		User user =new User();
		try{
			String query="SELECT * FROM user where  motdepasse ='" + password + "' and email = '"+ email+"'";
			rst=stm.executeQuery(query);
			while(rst.next()) {
				user.setEmail(rst.getString("email"));
			    user.setMotdepasse(rst.getString("motdepasse"));
				user.setAdmin(rst.getBoolean("admin"));
			}

		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}


		if (user.getEmail()==null)
		   return null;

		return user;
	}

}
