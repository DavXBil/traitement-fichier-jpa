package dal;


import bo.Produit;

public class DAOFactory {

	public static DAO<Produit> getProduitDAO() {
		return new ProduitDAO();
	}
}
