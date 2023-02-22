package pl.coderslab.portfolio;

import org.springframework.stereotype.Service;
import pl.coderslab.user.User;

import java.util.List;
import java.util.Optional;

@Service
public class JpaPortfolioService implements PortfolioService {
    private final PortfolioRepository portfolioRepository;

    public JpaPortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public List<Portfolio> getPortfolios() {
        return portfolioRepository.findAll();
    }

    @Override
    public Optional<Portfolio> getPortfolio(Long portfolioId) {
        return portfolioRepository.findById(portfolioId);
    }

    public List<Portfolio> getPortfoliosForUser(Long id) {
        return portfolioRepository.findPortfoliosByUser(id);
    }

    @Override
    public void addPortfolio(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    @Override
    public void editPortfolio(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    @Override
    public void deletePortfolio(Long portfolioId) {
        portfolioRepository.deleteById(portfolioId);
    }
}
