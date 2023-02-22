package pl.coderslab.transaction;

import pl.coderslab.user.User;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> getTransactions();
    Optional<Transaction> getTransaction(Long transactionId);
    void addTransaction(Transaction transaction);
    void editTransaction(Transaction transaction);
    void deleteTransaction(Long transactionId);
}
