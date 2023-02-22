package pl.coderslab;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pl.coderslab.coin.Coin;
import pl.coderslab.coin.JpaCoinService;
import pl.coderslab.portfolio.JpaPortfolioService;
import pl.coderslab.portfolio.Portfolio;
import pl.coderslab.transaction.JpaTransactionService;
import pl.coderslab.transaction.Transaction;
import pl.coderslab.user.JpaUserService;
import pl.coderslab.user.User;

import java.util.*;

@org.springframework.stereotype.Controller
public class Controller {
    private final JpaUserService jpaUserService;
    private final JpaPortfolioService jpaPortfolioService;
    private final JpaCoinService jpaCoinService;
    private final JpaTransactionService jpaTransactionService;

    public Controller(JpaUserService jpaUserService, JpaPortfolioService jpaPortfolioService, JpaCoinService jpaCoinService, JpaTransactionService jpaTransactionService) {
        this.jpaUserService = jpaUserService;
        this.jpaPortfolioService = jpaPortfolioService;
        this.jpaCoinService = jpaCoinService;
        this.jpaTransactionService = jpaTransactionService;
    }

    // 1. /user/

    @GetMapping("/user/all")
    public String listUsers(Model model) {
        List<User> users = jpaUserService.getUsers();
        model.addAttribute("users", users);
        return "/user/all";
    }

    @GetMapping("/user/get/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        Optional<User> optionalUser = jpaUserService.getUser(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
            return "/user/one";
        } else {
            return "/user/warning";
        }
    }

    @GetMapping("/user/portfolios/{id}")
    public String getUserPortfolios(@PathVariable Long id, Model model) {
        List<Portfolio> portfolios = jpaPortfolioService.getPortfoliosForUser(id);
        model.addAttribute("portfolios", portfolios);
        return "/portfolio/all";
    }

    @GetMapping("/user/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/user/add";
    }

    @PostMapping("/user/add")
    public String addUserFromForm(User user) {
        jpaUserService.addUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        Optional<User> optionalUser = jpaUserService.getUser(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
            return "/user/edit";
        } else {
            return "/user/warning";
        }
    }

    @PostMapping("/user/update")
    public String editUser(User user) {
        jpaUserService.editUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "/user/confirm";
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        jpaUserService.deleteUser(id);
        return "redirect:/user/all";
    }

    // 2. /portfolio/

    @GetMapping("/portfolio/all")
    public String listPortfolios(Model model) {
        List<Portfolio> portfolios = jpaPortfolioService.getPortfolios();
        model.addAttribute("portfolios", portfolios);
        return "/portfolio/all";
    }

    @GetMapping("/portfolio/get/{id}")
    public String getPortfolio(@PathVariable Long id, Model model) {
        Optional<Portfolio> optionalPortfolio = jpaPortfolioService.getPortfolio(id);
        if (optionalPortfolio.isPresent()) {
            Portfolio portfolio = optionalPortfolio.get();
            model.addAttribute("portfolio", portfolio);
            return "/portfolio/one";
        } else {
            return "/portfolio/warning";
        }
    }

    @GetMapping("/portfolio/coins/{id}")
    public String getPortfolioCoins(@PathVariable Long id, Model model) {
        List<Coin> coins = jpaCoinService.getCoinsForPortfolio(id);
        model.addAttribute("coins", coins);
        return "/coin/all";
    }

    @GetMapping("/portfolio/add/{id}")
    public String addPortfolio(@PathVariable Long id, Model model) {
        Portfolio portfolio = new Portfolio();
        model.addAttribute("portfolio", portfolio);
        model.addAttribute("userId", id);
        return "/portfolio/add";
    }

    @PostMapping("/portfolio/add")
    public String addPortfolioFromForm(Portfolio portfolio) {
        jpaPortfolioService.addPortfolio(portfolio);
        return "redirect:/portfolio/all";
    }

    @GetMapping("/portfolio/edit/{id}")
    public String editPortfolio(@PathVariable Long id, Model model) {
        Optional<Portfolio> optionalPortfolio = jpaPortfolioService.getPortfolio(id);
        if (optionalPortfolio.isPresent()) {
            Portfolio portfolio = optionalPortfolio.get();
            model.addAttribute("portfolio", portfolio);
            return "/portfolio/edit";
        } else {
            return "/portfolio/warning";
        }
    }

    @PostMapping("/portfolio/update")
    public String editPortfolio(Portfolio portfolio) {
        jpaPortfolioService.editPortfolio(portfolio);
        return "redirect:/portfolio/all";
    }

    @GetMapping("/portfolio/delete/{id}")
    public String deletePortfolio(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "/portfolio/confirm";
    }

    @PostMapping("/portfolio/delete/{id}")
    public String deletePortfolio(@PathVariable Long id) {
        jpaPortfolioService.deletePortfolio(id);
        return "redirect:/portfolio/all";
    }

    // 3. /coin/

    @GetMapping("/coin/all")
    public String listCoins(Model model) {
//        List<Coin> coins = jpaCoinService.getCoins();
//        model.addAttribute("coins", coins);
        return "/coin/all";
    }

    @GetMapping("/coin/get/{id}")
    public String getCoin(@PathVariable Long id, Model model) {
        Optional<Coin> optionalCoin = jpaCoinService.getCoin(id);
        if (optionalCoin.isPresent()) {
            Coin coin = optionalCoin.get();
            model.addAttribute("coin", coin);
            return "/coin/one";
        } else {
            return "/coin/warning";
        }
    }

    @GetMapping("/coin/add")
    public String addCoin(Model model) {
        Coin coin = new Coin();
        model.addAttribute("coin", coin);
        return "/coin/add";
    }

    @PostMapping("/coin/add")
    public String addCoinFromForm(Coin coin) {
        jpaCoinService.addCoin(coin);
        return "redirect:/coin/all";
    }

    @GetMapping("/coin/edit/{id}")
    public String editCoin(@PathVariable Long id, Model model) {
        Optional<Coin> optionalCoin = jpaCoinService.getCoin(id);
        if (optionalCoin.isPresent()) {
            Coin coin = optionalCoin.get();
            model.addAttribute("coin", coin);
            return "/coin/edit";
        } else {
            return "/coin/warning";
        }
    }

    @PostMapping("/coin/update")
    public String editCoin(Coin coin) {
        jpaCoinService.editCoin(coin);
        return "redirect:/coin/all";
    }

    @GetMapping("/coin/delete/{id}")
    public String deleteCoin(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "/coin/confirm";
    }

    @PostMapping("/coin/delete/{id}")
    public String deleteCoin(@PathVariable Long id) {
        jpaCoinService.deleteCoin(id);
        return "redirect:/coin/all";
    }

    // 4. /transaction/

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
