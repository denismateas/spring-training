package ro.msg.learning.shop.repository;

import ro.msg.learning.shop.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.needed.StockId;

import java.util.UUID;
@Repository
public interface StockRepository extends JpaRepository<Stock, StockId> {
}
