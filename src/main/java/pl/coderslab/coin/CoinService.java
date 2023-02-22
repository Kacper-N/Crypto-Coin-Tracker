package pl.coderslab.coin;

import pl.coderslab.user.User;

import java.util.List;
import java.util.Optional;

public interface CoinService {
    List<Coin> getCoins();
    Optional<Coin> getCoin(Long coinId);
    void addCoin(Coin coin);
    void editCoin(Coin coin);
    void deleteCoin(Long coinId);
}
