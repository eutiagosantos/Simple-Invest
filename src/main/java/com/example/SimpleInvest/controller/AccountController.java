package com.example.SimpleInvest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SimpleInvest.dtos.AssociateAccountStockDto;
import com.example.SimpleInvest.dtos.AccountStockResponseDto;
import com.example.SimpleInvest.service.AccountService;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
    
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/stock")
    public ResponseEntity<Void> associateStock(@PathVariable("accountId") String accountId,
            @RequestBody AssociateAccountStockDto dto) {

        accountService.associateAccont(accountId, dto);
        
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}/stock")
    public ResponseEntity<List<AccountStockResponseDto>> associateStock(@PathVariable("accountId") String accountId) {
        
        List<AccountStockResponseDto> stocks = accountService.listStocks(accountId);
        
        return ResponseEntity.ok(stocks);
    }
    
}