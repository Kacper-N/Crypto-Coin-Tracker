package pl.coderslab.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class TransactionController {

    private final JpaTransactionService jpaTransactionService;

    public TransactionController(JpaTransactionService jpaTransactionService) {
        this.jpaTransactionService = jpaTransactionService;
    }

    @GetMapping("/transaction/all")
    public String listTransactions(Model model) {
        List<Transaction> transactions = jpaTransactionService.getTransactions();
        model.addAttribute("transactions", transactions);
        return "/transaction/all";
    }

    @GetMapping("/transaction/get/{id}")
    public String getTransaction(@PathVariable Long id, Model model) {
        Optional<Transaction> optionalTransaction = jpaTransactionService.getTransaction(id);
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            model.addAttribute("transaction", transaction);
            return "/transaction/one";
        } else {
            return "/transaction/warning";
        }
    }

    @GetMapping("/transaction/add")
    public String addTransaction(Model model) {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "/transaction/add";
    }

    @PostMapping("/transaction/add")
    public String addTransactionFromForm(Transaction transaction) {
        jpaTransactionService.addTransaction(transaction);
        return "redirect:/transaction/all";
    }

    @GetMapping("/transaction/edit/{id}")
    public String editTransaction(@PathVariable Long id, Model model) {
        Optional<Transaction> optionalTransaction = jpaTransactionService.getTransaction(id);
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            model.addAttribute("transaction", transaction);
            return "/transaction/edit";
        } else {
            return "/transaction/warning";
        }
    }

    @PostMapping("/transaction/update")
    public String editTransaction(Transaction transaction) {
        jpaTransactionService.editTransaction(transaction);
        return "redirect:/transaction/all";
    }

    @GetMapping("/transaction/delete/{id}")
    public String deleteTransaction(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "/transaction/confirm";
    }

    @PostMapping("/transaction/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        jpaTransactionService.deleteTransaction(id);
        return "redirect:/transaction/all";
    }
}
