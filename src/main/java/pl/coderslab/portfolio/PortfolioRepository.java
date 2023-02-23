package pl.coderslab.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    @Query("select p from Portfolio p where p.user.id = :id")
    List<Portfolio> findPortfoliosByUserId(@Param("id") long id);
}
