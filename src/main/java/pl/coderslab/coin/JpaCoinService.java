package pl.coderslab.coin;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaCoinService implements CoinService{
    private final CoinRepository coinRepository;

    public JpaCoinService(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    @Override
    public List<Coin> getCoins() {
        return coinRepository.findAll();
    }

    @Override
    public Optional<Coin> getCoin(Long coinId) {
        return coinRepository.findById(coinId);
    }

    public List<Coin> getCoinsForPortfolio(Long id) {
        return coinRepository.findCoinsByPortfolioId(id);
    }

    @Override
    public void addCoin(Coin coin) {
        coinRepository.save(coin);
    }

    @Override
    public void editCoin(Coin coin) {
        coinRepository.save(coin);
    }

    @Override
    public void deleteCoin(Long coinId) {
        coinRepository.deleteById(coinId);
    }
}
