package dal;

import bll.ConnectionManager;
import bo.Categorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategorieDAO implements DAO<Categorie>{

    private final EntityManagerFactory emf = ConnectionManager.getInstance().getEmf();
    private final EntityManager em = emf.createEntityManager();


    @Override
    public void create(Categorie categorie) throws DALException {
        try {
            em.getTransaction().begin();
            em.persist(categorie);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }
    }

    @Override
    public void update(Categorie categorie) throws DALException {

    }

    @Override
    public void delete(Categorie categorie) throws DALException {

    }

    @Override
    public List<Categorie> selectAll() throws DALException {
        return null;
    }

    @Override
    public Categorie selectById(long id) throws DALException {
        return null;
    }

    public Categorie selectByLibelle(String libelle) throws DALException {

        TypedQuery<Categorie> query = em.createQuery("select e from Categorie e where e.libelle = :libelle", Categorie.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
