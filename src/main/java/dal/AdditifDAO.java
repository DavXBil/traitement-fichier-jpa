package dal;

import bll.ConnectionManager;
import bo.Additif;
import bo.Allergene;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AdditifDAO implements DAO<Additif> {

    private final EntityManagerFactory emf = ConnectionManager.getInstance().getEmf();
    private final EntityManager em = emf.createEntityManager();

    @Override
    public void create(Additif additif) throws DALException {
        try {
            em.getTransaction().begin();
            em.persist(additif);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new DALException("Erreur lors de la création de l'additif", e);
        }
    }

    @Override
    public void update(Additif additif) throws DALException {

    }

    @Override
    public void delete(Additif additif) throws DALException {

    }

    @Override
    public List<Additif> selectAll() throws DALException {
        return null;
    }

    @Override
    public Additif selectById(long id) throws DALException {
        return null;
    }

    public Additif selectByLibelle(String libelle) throws DALException {

        TypedQuery<Additif> query = em.createQuery("select e from Additif e where e.libelle = :libelle", Additif.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }

}
