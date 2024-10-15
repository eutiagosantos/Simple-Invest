package com.example.SimpleInvest.service;

import org.springframework.stereotype.Service;

import com.example.SimpleInvest.dtos.CreateStockDto;
import com.example.SimpleInvest.entity.Stock;
import com.example.SimpleInvest.repository.StockRepository;

@Service
public class StockService {
    
    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock createStock(CreateStockDto stockDto){
        var entity = new Stock(
            stockDto.stockId(),
            stockDto.description()
        );

        return stockRepository.save(entity);
    }

    
}