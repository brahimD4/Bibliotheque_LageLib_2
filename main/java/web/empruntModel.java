package web;

import java.util.ArrayList;
import java.util.List;

import metier.historique;

public class empruntModel {
	private String motCle;
	private List<historique> historiques = new ArrayList<historique>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<historique> getHistoriques() {
		return historiques;
	}
	public void setHistoriques(List<historique> Historique) {
		this.historiques = Historique;
	}
	
}
