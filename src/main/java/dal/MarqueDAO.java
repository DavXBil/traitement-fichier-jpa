package dal;

import bll.ConnectionManager;
import bo.Categorie;
import bo.Marque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class MarqueDAO implements DAO<Marque> {

    private final EntityManagerFactory emf = ConnectionManager.getInstance().getEmf();
    private final EntityManager em = emf.createEntityManager();

    @Override
    public void create(Marque marque) throws DALException {
        try {
            em.getTransaction().begin();
            em.persist(marque);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new DALException("Erreur lors de la création de la marque", e);
        }
    }

    @Override
    public void update(Marque marque) throws DALException {

    }

    @Override
    public void delete(Marque marque) throws DALException {

    }

    @Override
    public List<Marque> selectAll() throws DALException {
        return null;
    }

    @Override
    public Marque selectById(long id) throws DALException {
        return null;
    }

    public Marque selectByLibelle(String libelle) throws DALException {

        TypedQuery<Marque> query = em.createQuery("select e from Marque e where e.libelle = :libelle", Marque.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
