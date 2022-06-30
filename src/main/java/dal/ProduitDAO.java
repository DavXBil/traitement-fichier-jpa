package dal;

import bll.ConnectionManager;
import bo.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProduitDAO implements DAO<Produit> {

    private final EntityManagerFactory emf = ConnectionManager.getInstance().getEmf();
    private final EntityManager em = emf.createEntityManager();


    @Override
    public void create(Produit produit) throws DALException {
        try {
            em.getTransaction().begin();
            em.persist(produit);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new DALException("Erreur lors de la création du produit", e);
        }

    }

    @Override
    public void update(Produit produit) throws DALException {

    }

    @Override
    public void delete(Produit produit) throws DALException {

    }

    @Override
    public List<Produit> selectAll() throws DALException {
        return null;
    }

    @Override
    public Produit selectById(long id) throws DALException {
        return null;
    }
}
