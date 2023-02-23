package pl.coderslab.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.coin.Coin;
import pl.coderslab.coin.JpaCoinService;

import java.util.List;
import java.util.Optional;

@Controller
public class PortfolioController {

    private final JpaPortfolioService jpaPortfolioService;

    private final JpaCoinService jpaCoinService;

    public PortfolioController(JpaPortfolioService jpaPortfolioService, JpaCoinService jpaCoinService) {
        this.jpaPortfolioService = jpaPortfolioService;
        this.jpaCoinService = jpaCoinService;
    }

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
}
