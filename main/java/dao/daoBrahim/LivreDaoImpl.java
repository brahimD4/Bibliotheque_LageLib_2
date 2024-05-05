package dao.daoBrahim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import metier.Livre;





public class LivreDaoImpl implements IlivreDio {

	@Override
	public Livre Save(Livre livre) {
		
		Connection connection=SinglotonConnection.getConnection();
		
		
		try {
			String Query="INSERT INTO livres(titre,auteur,editeur,année_de_publication)VALUES(?,?,?,?)";
			  PreparedStatement ps=connection.prepareStatement(Query);
			  ps.setString(1, livre.getTitre());
			  ps.setString(2, livre.getAuteur());
			  ps.setString(3, livre.getEditeur());
			  ps.setDate(4, livre.getAnnée_de_publication());
			  ps.executeUpdate(); 
			  
			  PreparedStatement ps2=connection.prepareStatement("SELECT MAX(livre_id) AS MAXID FROM livres");
			  ResultSet rs=ps2.executeQuery(); 
			  if(rs.next()) { 
				  livre.setId(rs.getInt("MAXID"));
			
			  } 
			  ps.close(); 
			  } catch (SQLException e) { 
			  e.printStackTrace(); 
			  }
			  
			 
			  
		// TODO Auto-generated method stub
		return livre;
	}



	  @Override public List<Livre> getTousLivres() {
		  
		  List<Livre> livres=new ArrayList<>(); 
		  
		  Connection connection= SinglotonConnection.getConnection();
		  
		  try {
			  PreparedStatement ps=connection.prepareStatement("SELECT* FROM livres");
		  
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()){
			  Livre liv=new Livre();
			  
			  liv.setId(rs.getInt("livre_id")); 
			  liv.setTitre(rs.getString("titre"));
			  liv.setAuteur(rs.getString("auteur"));
			  liv.setEditeur(rs.getString("editeur"));
			  liv.setAnnée_de_publication(rs.getDate("année_de_publication"));
			  
			  livres.add(liv);
			  
		  }
		 
		  ps.close();
		  } catch(SQLException e) { 
		   
		  }
	
		  return livres; 
	
	  }



	@Override
	public void deleteLivre(int id) {
		 Connection connection=SinglotonConnection.getConnection();
		
		 try {
			String Query="DELETE FROM livres WHERE livre_id=?";
			PreparedStatement ps=connection.prepareStatement(Query);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		 
	
	}



	@Override
	public List<Livre> recherche(String motCle) {
		List<Livre> livresRecherche =new ArrayList<>();
		Connection connection=SinglotonConnection.getConnection();
		 try {
				String Query="SELECT* FROM livres WHERE titre LIKE ?";
				PreparedStatement ps=connection.prepareStatement(Query);
				ps.setString(1, motCle);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					Livre liv=new Livre();
					liv.setId(rs.getInt("livre_id"));
					liv.setTitre(rs.getString("titre"));
					liv.setAuteur(rs.getString("auteur"));
					liv.setEditeur(rs.getString("editeur"));
					liv.setAnnée_de_publication(rs.getDate("année_de_publication"));
					 
					livresRecherche.add(liv);
				}
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		 
		 return livresRecherche ;
	}



	

	@Override
	public Livre getLivre(int id) {
		Livre liv=new Livre();
		Connection connection=SinglotonConnection.getConnection();
		try {
			String Query="SELECT * FROM livres WHERE livre_id=?";
			PreparedStatement ps=connection.prepareStatement(Query);

			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			
				liv.setId(rs.getInt("livre_id"));
				liv.setTitre(rs.getString("titre"));
				liv.setAuteur(rs.getString("auteur"));
				liv.setEditeur(rs.getString("editeur"));
				liv.setAnnée_de_publication(rs.getDate("année_de_publication"));
			}
			ps.close();
		}catch(SQLException e) {
		   e.printStackTrace();	
		}
		
		return liv;
	}



	@Override
	public Livre updateLivre(Livre livr) {
		Connection connection=SinglotonConnection.getConnection();
		try {
			String Query="UPDATE livres SET titre=?, auteur=? ,editeur=? ,année_de_publication=? WHERE livre_id=?";
			PreparedStatement ps=connection.prepareStatement(Query);
			ps.setString(1, livr.getTitre());
			ps.setString(2, livr.getAuteur());
			ps.setString(3, livr.getEditeur());
			ps.setDate(4, livr.getAnnée_de_publication());
			ps.setInt(5, livr.getId());
	        ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.getStackTrace();
		}
		
		return livr;
	}
	
	
	  /*
	  @Override public List<Produit> ProduitsParMC(String mc) { List<Produit>
	  produits=new ArrayList<>(); Connection connection=
	  SinglotonConnection.getConnection();
	  
	  try { PreparedStatement
	  ps=connection.prepareStatement("SELECT* FROM produits WHERE nom_produit=? ");
	  
	  ps.setString(1, mc); ResultSet rs=ps.executeQuery(); while(rs.next()) {
	  
	  
	  Produit p=new Produit(); p.setId(rs.getInt("id"));
	  p.setNomProduit(rs.getString("nom_produit"));
	  p.setPrix(rs.getDouble("prix"));
	  p.setQuantite(rs.getInt("quantite_en_stock"));
	  p.setDescription(rs.getString("descript")); produits.add(p); } } catch
	  (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	  return produits; }
	  
	  @Override public Produit getProduit(int id) { Connection connection=
	  SinglotonConnection.getConnection(); Produit p=new Produit(); try {
	  PreparedStatement
	  ps=connection.prepareStatement("SELECT* FROM produits WHERE id=? ");
	  
	  ps.setInt(1, id); ResultSet rs=ps.executeQuery(); if(rs.next()) {
	  
	  p.setId(rs.getInt("id")); p.setNomProduit(rs.getString("nom_produit"));
	  p.setPrix(rs.getDouble("prix"));
	  p.setQuantite(rs.getInt("quantite_en_stock"));
	  p.setDescription(rs.getString("descript"));
	  
	  } } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); }
	  
	  return p; }
	  
	  @Override public Produit updateProduit(Produit p) { Connection connection=
	  SinglotonConnection.getConnection(); try { PreparedStatement ps=connection.
	  prepareStatement("UPDATE  produits SET nom_produit=?,prix=?,quantite_en_stock=?,descript=? WHERE id=?"
	  );
	  
	  ps.setString(1, p.getNomProduit()); ps.setDouble(2, p.getPrix());
	  ps.setInt(3, p.getQuantite()); ps.setString(4, p.getDescription());
	  ps.setInt(5,p.getId());
	  
	  ps.executeUpdate(); ps.close();
	  
	  } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return p; }
	  
	  @Override
	   public void deleteProduit(int id) {
	  
	  
	 
	  Connection connection= SinglotonConnection.getConnection(); 
	  try {
	  PreparedStatement
	  ps=connection.prepareStatement("DELETE FROM produits WHERE ID=?");
	  ps.setInt(1, id); 
	  ps.executeUpdate(); 
	  ps.close(); 
	  } catch (SQLException e) {
	  // TODO Auto-generated catch block e.printStackTrace(); 
	   * }
	  
	  
	  
	  }
	  
	  @Override public List<Produit> getTousProduits() {
	  
	  List<Produit> produits=new ArrayList<>(); Connection connection=
	  SinglotonConnection.getConnection();
	  
	  try { PreparedStatement
	  ps=connection.prepareStatement("SELECT* FROM produits");
	  
	  ResultSet rs=ps.executeQuery(); 
	  while(rs.next()) { 
	  Produit p=new Produit();
	  p.setId(rs.getInt("id"));
	  p.setNomProduit(rs.getString("nom_produit"));
	  p.setPrix(rs.getDouble("prix"));
	  p.setQuantite(rs.getInt("quantite_en_stock"));
	  p.setDescription(rs.getString("descript")); produits.add(p); } } catch
	  (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	  return produits; }
	 
*/
	}
