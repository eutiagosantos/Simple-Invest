package com.example.SimpleInvest.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SimpleInvest.dtos.CreateStockDto;
import com.example.SimpleInvest.entity.Stock;
import com.example.SimpleInvest.service.StockService;

@RestController
@RequestMapping("/v1/stocks")
public class StockController {

    private StockService stockService;

    

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }



    @PostMapping
    public ResponseEntity<Stock> createUser(@RequestBody CreateStockDto stockDto) {
        stockService.createStock(stockDto);
        return ResponseEntity.ok().build();
    }
}