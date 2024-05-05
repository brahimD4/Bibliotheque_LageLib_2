package dao.daoBrahim;

import java.util.List;

import metier.Livre;


public interface IlivreDio {
    public Livre Save(Livre livre);
    public List<Livre> getTousLivres();
    public  void deleteLivre(int id);
    public List<Livre> recherche(String motCle);
	public Livre updateLivre(Livre livr);
	public Livre getLivre(int id);
}
