package com.example.SimpleInvest.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.SimpleInvest.Client.BrapiClient;
import com.example.SimpleInvest.dtos.AccountStockResponseDto;
import com.example.SimpleInvest.dtos.AssociateAccountStockDto;
import com.example.SimpleInvest.entity.AccountStock;
import com.example.SimpleInvest.entity.AccountStockId;
import com.example.SimpleInvest.repository.AccountRepository;
import com.example.SimpleInvest.repository.AccountStockRepository;
import com.example.SimpleInvest.repository.StockRepository;


@Service
public class AccountService {
 
    @Value("#{environment.TOKEN}")
    private String TOKEN;
    private final AccountRepository accountRepository;
    private StockRepository stockRepository;
    private AccountStockRepository accountStockRepository;
    private BrapiClient brapiClient;

    public AccountService(AccountRepository accountRepository, StockRepository stockRepository, AccountStockRepository accountStockRepository, BrapiClient brapiClient) {
        this.accountRepository = accountRepository;
        this.stockRepository = stockRepository;
        this.accountStockRepository = accountStockRepository;
        this.brapiClient = brapiClient;
    }

    public void associateAccont(String accountId, AssociateAccountStockDto dto) {
        
        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        var stock = stockRepository.findById(dto.stockId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var id = new AccountStockId(account.getAccountId(), stock.getStockId());
        
        var entity = new AccountStock(
            id,
            account,
            stock,
            dto.quantity()
        );

        accountStockRepository.save(entity);
    }

    public List<AccountStockResponseDto> listStocks(String accountId) {
        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return account.getAccountStocks()
                    .stream()
                    .map(as -> new AccountStockResponseDto(as.getStock().getStockId(), 
                    as.getQuantity(), 
                    getTotal(as.getStock().getStockId(), 
                    as.getQuantity())))
                    .toList();
    }

    private double getTotal(String stockId, Integer quantity) {
       var response = brapiClient.getQuote(TOKEN, stockId);
       var results = response.results();
       
       if (!results.isEmpty()) {
            var price = results.get(0).regularMarketPrice();
            return price * quantity;
        }

        throw new RuntimeException("No stock information found for: " + stockId);
    }

}