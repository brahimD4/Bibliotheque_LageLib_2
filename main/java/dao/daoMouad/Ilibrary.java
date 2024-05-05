package dao.daoMouad;

import java.util.List;

import metier.historique;

public interface Ilibrary {
	public List<historique> chercher(String mc);
	public List<historique> Afficher();	
}
