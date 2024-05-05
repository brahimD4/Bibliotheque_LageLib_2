package web;

import java.util.ArrayList;
import java.util.List;

import metier.Livre;



public class ModelLivre {
		private String motCle;
		private List<Livre> livres  =new ArrayList<Livre>();
		public String getMotCle() {
			return motCle;
		}
		public void setMotCle(String motCle) {
			this.motCle = motCle;
		}
		public List<Livre> getLivres() {
			return livres;
		}
		public void setLivres(List<Livre> livres) {
			this.livres = livres;
		}
		
		
		
		
	

}
