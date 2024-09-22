import jakarta.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountId", nullable = false)
    private int accountId;

    @Column(name = "AccountName")
    private String accountName;

    @Column(name = "Balance")
    private double balance;

    public Account(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public Account() {
    }

    // Getters and Setters

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
