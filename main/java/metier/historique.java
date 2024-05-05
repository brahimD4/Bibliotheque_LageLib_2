package metier;

import java.sql.Date;

public class historique {
	private String titre;
	private String auteur;
	private Date date_retour;
	private Date date_emprunt;
	private String statut;
	public historique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public historique(String titre, String auteur, Date date_retour, Date date_emprunt, String statut) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.date_retour = date_retour;
		this.date_emprunt = date_emprunt;
		this.statut = statut;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Date getDate_retour() {
		return date_retour;
	}
	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}
	public Date getDate_emprunt() {
		return date_emprunt;
	}
	public void setDate_emprunt(Date date_emprunt) {
		this.date_emprunt = date_emprunt;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "historique [titre=" + titre + ", auteur=" + auteur + ", date_retour=" + date_retour + ", date_emprunt="
				+ date_emprunt + ", statut=" + statut + "]";
	}
	
}
