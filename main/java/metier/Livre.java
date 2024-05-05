package metier;

import java.sql.Date;

public class Livre {
    private int id ;
    private String titre ;
    private String auteur ;
	private String editeur ;
	private Date année_de_publication ;
	
	
	public Livre() {
		
	}
	public Livre(String titre, String auteur, String editeur, Date année_de_publication) {
	
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.année_de_publication = année_de_publication;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public Date getAnnée_de_publication() {
		return année_de_publication;
	}
	public void setAnnée_de_publication(Date année_de_publication) {
		this.année_de_publication = année_de_publication;
	}

}
