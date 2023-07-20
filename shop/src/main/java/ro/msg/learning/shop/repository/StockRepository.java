package ro.msg.learning.shop.repository;

import ro.msg.learning.shop.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface StockRepository extends JpaRepository<Stock, UUID> {
}
