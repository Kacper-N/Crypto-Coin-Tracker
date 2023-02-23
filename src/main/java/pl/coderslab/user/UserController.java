package pl.coderslab.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.portfolio.JpaPortfolioService;
import pl.coderslab.portfolio.Portfolio;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final JpaUserService jpaUserService;

    private final JpaPortfolioService jpaPortfolioService;

    public UserController(JpaUserService jpaUserService, JpaPortfolioService jpaPortfolioService) {
        this.jpaUserService = jpaUserService;
        this.jpaPortfolioService = jpaPortfolioService;
    }

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
}
