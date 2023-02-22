package pl.coderslab.coin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends JpaRepository<Coin,Long> {
    @Query("select c from Coin c where c.portfolio.id = :id")
    List<Coin> findCoinsByPortfolio(@Param("id") long id);
}
