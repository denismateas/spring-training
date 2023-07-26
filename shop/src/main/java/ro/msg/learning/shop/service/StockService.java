package ro.msg.learning.shop.service;


import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.needed.StockId;


public interface StockService {
    public Stock updateStock(Stock stock);

    public Stock getStockById(StockId stockId);
}
