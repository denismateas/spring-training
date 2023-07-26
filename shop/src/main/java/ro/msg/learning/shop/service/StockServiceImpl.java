package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.needed.StockId;
import ro.msg.learning.shop.repository.StockRepository;

import java.util.UUID;
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;
    @Override
    public Stock updateStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStockById(StockId stockId) {
        return stockRepository.getReferenceById(stockId);
    }
}
