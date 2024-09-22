import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TransactionDAO {

    private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("finance");

    public void saveTransaction(Transaction transaction) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateTransaction(Transaction transaction) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(transaction);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeTransaction(Transaction transaction) {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(transaction) ? transaction : entityManager.merge(transaction));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Transaction getTransaction(int id) {
        EntityManager entityManager = em.createEntityManager();
        Transaction transaction = entityManager.find(Transaction.class, id);
        entityManager.close();
        return transaction;
    }

}
