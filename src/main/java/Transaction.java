import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionId", nullable = false)
    private int transactionId;

    @Column(name = "Amount")
    private double amount;

    @Column(name = "Description")
    private String description;

    @Column(name = "Timestamp")
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PaidFrom", referencedColumnName = "AccountId")
    private Account paidFrom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PaidTo", referencedColumnName = "AccountId")
    private Account paidTo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    private Category category;

    public Transaction(double amount, String description, LocalDateTime timestamp, Account paidFrom, Account paidTo, Category category) {
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.paidFrom = paidFrom;
        this.paidTo = paidTo;
        this.category = category;
    }

    public Transaction() {
    }

    // Getters and Setters

    public String toString() {
        return "Transaction [transactionId = \n" + transactionId + ", amount = \n" + amount +
                ", description = \n" + description + ", timestamp = \n" + timestamp +
                ", paidFrom = \n" + (paidFrom != null ? paidFrom.getAccountName() : "None") +
                ", paidTo = \n" + (paidTo != null ? paidTo.getAccountName() : "None") +
                ", category = \n" + category.getCategoryDescription() + "]";
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Account getPaidFrom() {
        return paidFrom;
    }

    public void setPaidFrom(Account paidFrom) {
        this.paidFrom = paidFrom;
    }

    public Account getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(Account paidTo) {
        this.paidTo = paidTo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
