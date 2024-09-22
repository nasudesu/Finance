import java.time.LocalDateTime;

public class FinanceTest {
    public static void main(String[] args) {

        AccountDAO accountDAO = new AccountDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        // Add sample categories
        Category food = new Category("Food");
        Category leisure = new Category("Leisure");
        Category school = new Category("School");
        Category gift = new Category("Gift");
        Category internalTransfer = new Category("Internal Transfer");

        //Presist categories
        categoryDAO.saveCategory(food);
        categoryDAO.saveCategory(leisure);
        categoryDAO.saveCategory(school);
        categoryDAO.saveCategory(gift);
        categoryDAO.saveCategory(internalTransfer);

        // 2. Generate a savings account with a € 400.00 balance.

        Account savings = new Account("Savings", 400.00);
        accountDAO.saveAccount(savings);

        // 3. Generate a wallet with a € 14.50 balance.

        Account wallet = new Account("Wallet", 14.50);
        accountDAO.saveAccount(wallet);

        // 4. Receive a gift of € 100.00 from Aunt Mary to the savings account.
        // (The source account should be null.)

        Transaction giftTransaction = new Transaction(100.00, "Gift from Aunt Mary", LocalDateTime.now(), null, savings, gift);
        transactionDAO.saveTransaction(giftTransaction);

        // 5. Transfer € 40.00 from the savings account to the wallet (internal transfer).

        Transaction transferTransaction = new Transaction(40.00, "Internal Transfer to Wallet", LocalDateTime.now(), savings, wallet, internalTransfer);
        transactionDAO.saveTransaction(transferTransaction);

        // 6. Spend € 8.40 from the wallet in the pub. (The target account should be null).

        Transaction pubTransaction = new Transaction(8.40, "Spent in Pub", LocalDateTime.now(), wallet, null, leisure);
        transactionDAO.saveTransaction(pubTransaction);

    }
}
