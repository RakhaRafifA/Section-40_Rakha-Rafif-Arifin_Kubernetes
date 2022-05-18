package com.rakharafifa.miniproject.controller;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.WalletDto;
import com.rakharafifa.miniproject.model.entity.WalletEntity;
import com.rakharafifa.miniproject.service.interfaces.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miniproject/wallet")
public class WalletController {
    WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @GetMapping
    public ResponseEntity<List<WalletEntity>> getAllWallet(){
        List<WalletEntity> wallets = walletService.getAllWallet();
        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<WalletDto>> getAllWalletDto(){
        List<WalletDto> walletDtos = walletService.getAllWalletDto();
        return new ResponseEntity<>(walletDtos, HttpStatus.OK);
    }

    @GetMapping("/{wallet_id}")
    public ResponseEntity<WalletEntity> getWalletById(@PathVariable("wallet_id") Long wallet_id){
        return new ResponseEntity<>(walletService.getWalletById(wallet_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WalletEntity> createWallet(@RequestBody WalletEntity wallet){
        walletService.createWallet(wallet);
        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }

    @PutMapping("/{wallet_id}")
    public ResponseEntity<WalletEntity> updateWallet(@PathVariable("wallet_id") Long wallet_id, @RequestBody WalletEntity wallet){
        walletService.updateWallet(wallet_id, wallet);
        return new ResponseEntity<>(walletService.getWalletById(wallet_id), HttpStatus.OK);
    }

    @DeleteMapping("/{wallet_id}")
    public ResponseEntity<WalletEntity> deleteWallet(@PathVariable("wallet_id") Long wallet_id){
        walletService.deleteWallet(wallet_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
