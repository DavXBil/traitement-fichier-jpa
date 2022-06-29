package dal;

import bo.Categorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CategorieDAO implements DAO<Categorie>{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("food-jpa");
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

        try {

            return em.createQuery("SELECT c FROM Categorie c where c.libelle =" + libelle, Categorie.class).setMaxResults(1).getSingleResult();

        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }
        return null;
    }
}
