package pl.coderslab.coin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.transaction.JpaTransactionService;
import pl.coderslab.transaction.Transaction;

import java.util.List;
import java.util.Optional;

@Controller
public class CoinController {

    private final JpaCoinService jpaCoinService;

    private final JpaTransactionService jpaTransactionService;

    public CoinController(JpaCoinService jpaCoinService, JpaTransactionService jpaTransactionService) {
        this.jpaCoinService = jpaCoinService;
        this.jpaTransactionService = jpaTransactionService;
    }

    @GetMapping("/coin/all")
    public String listCoins(Model model) {
        List<Coin> coins = jpaCoinService.getCoins();
        model.addAttribute("coins", coins);
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

    @GetMapping("/coin/transactions/{id}")
    public String getCoinTransactions(@PathVariable Long id, Model model) {
        List<Transaction> transactions = jpaTransactionService.getTransactionsForCoin(id);
        model.addAttribute("transactions", transactions);
        return "/transaction/all";
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
}
