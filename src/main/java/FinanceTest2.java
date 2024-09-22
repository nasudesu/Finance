import java.util.Scanner;

public class FinanceTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for transaction ID
        System.out.print("Enter Transaction ID: ");
        int transactionId = scanner.nextInt();

        // Fetch the transaction by ID
        TransactionDAO transactionDAO = new TransactionDAO();
        Transaction transaction = transactionDAO.getTransaction(transactionId);

        // Check if transaction exists
        if (transaction != null) {
            // Print the transaction description
            System.out.println(transaction);
        } else {
            System.out.println("Transaction not found!");
        }

        scanner.close();
    }
}
