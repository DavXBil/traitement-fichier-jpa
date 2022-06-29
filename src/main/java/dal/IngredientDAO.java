package dal;

import bll.ConnectionManager;
import bo.Categorie;
import bo.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class IngredientDAO implements DAO<Ingredient> {

    private final EntityManagerFactory emf = ConnectionManager.getInstance().getEmf();
    private final EntityManager em = emf.createEntityManager();

    @Override
    public void create(Ingredient ingredient) throws DALException {
        try {
            em.getTransaction().begin();
            em.persist(ingredient);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }
    }

    @Override
    public void update(Ingredient ingredient) throws DALException {

    }

    @Override
    public void delete(Ingredient ingredient) throws DALException {

    }

    @Override
    public List<Ingredient> selectAll() throws DALException {
        return null;
    }

    @Override
    public Ingredient selectById(long id) throws DALException {
        return null;
    }

    public Ingredient selectByLibelle(String libelle) throws DALException {
        TypedQuery<Ingredient> query = em.createQuery("select e from Ingredient e where e.libelle = :libelle", Ingredient.class);
        query.setParameter("libelle", libelle);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null;
    }
}
