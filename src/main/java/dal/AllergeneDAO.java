package dal;

import bll.ConnectionManager;
import bo.Additif;
import bo.Allergene;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AllergeneDAO implements DAO<Allergene> {

    private final EntityManagerFactory emf = ConnectionManager.getInstance().getEmf();
    private final EntityManager em = emf.createEntityManager();



    @Override
    public void create(Allergene allergene) throws DALException {
        try {
            em.getTransaction().begin();
            em.persist(allergene);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new DALException("Erreur lors de la création de l'allergene", e);
        }
    }

    @Override
    public void update(Allergene allergene) throws DALException {

    }

    @Override
    public void delete(Allergene allergene) throws DALException {

    }

    @Override
    public List<Allergene> selectAll() throws DALException {
        return null;
    }

    @Override
    public Allergene selectById(long id) throws DALException {
        return null;
    }

    public Allergene selectByLibelle(String libelle) throws DALException {

        TypedQuery<Allergene> query = em.createQuery("select e from Allergene e where e.libelle = :libelle", Allergene.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
