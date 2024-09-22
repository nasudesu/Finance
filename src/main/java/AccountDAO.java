import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AccountDAO {

    private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("finance");

    public void saveAccount(Account account) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateAccount(Account account) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(account);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeAccount(Account account) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(account) ? account : entityManager.merge(account));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Account getAccount(int id) {
        EntityManager entityManager = em.createEntityManager();
        Account account = entityManager.find(Account.class, id);
        entityManager.close();
        return account;
    }

}
