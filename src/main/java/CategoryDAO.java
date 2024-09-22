import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoryDAO {

    private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("finance");

    public void saveCategory(Category category) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateCategory(Category category) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeCategory(Category category) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Category getCategory(int id) {
        EntityManager entityManager = em.createEntityManager();
        Category category = entityManager.find(Category.class, id);
        entityManager.close();
        return category;
    }
}
