package pl.coderslab.portfolio;

import java.util.List;
import java.util.Optional;

public interface PortfolioService {
    List<Portfolio> getPortfolios();
    Optional<Portfolio> getPortfolio(Long portfolioId);
    void addPortfolio(Portfolio portfolio);
    void editPortfolio(Portfolio portfolio);
    void deletePortfolio(Long portfolioId);
}
