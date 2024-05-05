package dao.daoMouad;


import metier.historique;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IlibraryImpl implements Ilibrary{

	
	@Override
	public List<historique> chercher(String mc) {
		List<historique> historique=new ArrayList<historique>();
		Connection connection = ConnectionJDBC.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("select titre , auteur, date_retour, date_emprunt, statut from livres inner join emprunts on livres.livre_id=emprunts.livre_id "
							+ "where titre like ? or auteur like ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				historique E=new historique();
				E.setTitre(rs.getString("titre"));
				E.setAuteur(rs.getString("auteur"));
				E.setDate_emprunt(rs.getDate("date_emprunt"));
				E.setDate_retour(rs.getDate("date_retour"));
				E.setStatut(rs.getString("statut"));
				historique.add(E);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return historique;
	}

	@Override
	public List<historique> Afficher() {
		List<historique> Historique=new ArrayList<historique>();
		Connection connection = ConnectionJDBC.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("select titre , auteur, date_retour, date_emprunt, statut from livres inner join emprunts on livres.livre_id=emprunts.livre_id");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				historique E=new historique();
				E.setTitre(rs.getString("titre"));
				E.setAuteur(rs.getString("auteur"));
				E.setDate_emprunt(rs.getDate("date_emprunt"));
				E.setDate_retour(rs.getDate("date_retour"));
				E.setStatut(rs.getString("statut"));
				Historique.add(E);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Historique;
		}
	
}
