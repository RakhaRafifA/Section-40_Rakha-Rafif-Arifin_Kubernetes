package com.rakharafifa.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto_create.CreateWalletDTO;
import com.rakharafifa.miniproject.model.dto_get.WalletDto;
import com.rakharafifa.miniproject.model.entity.User;
import com.rakharafifa.miniproject.model.entity.Wallet;
import com.rakharafifa.miniproject.repository.WalletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {
    WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    @Override
    public List<Wallet> getAllWallet() {
        List<Wallet> wallets = new ArrayList<>();
        walletRepository.findAll().forEach(wallets::add);
        return wallets;
    }

    @Override
    public List<WalletDto> getAllWalletDto() {
        List<Wallet> wallets = walletRepository.findAll();
        List<WalletDto> walletDtos = new ArrayList<>();
        for(Wallet wallet : wallets){
            WalletDto walletDto = new WalletDto();
            User userDto = new User();

            walletDto.setWallet_id(wallet.getWallet_id());
            walletDto.setName(wallet.getName());
            walletDto.setAmount(wallet.getAmount());
            walletDto.setUser_id(wallet.getUser().getUser_id());

            userDto.setUser_id(wallet.getUser().getUser_id());
            userDto.setName(wallet.getUser().getName());
            userDto.setUsername(wallet.getUser().getUsername());

            walletDtos.add(walletDto);
        }
        return walletDtos;
    }

    @Override
    public Wallet getWalletById(Long wallet_id) {
        return walletRepository.findById(wallet_id).get();
    }

    @Override
    public void createWalletDto(CreateWalletDTO createWalletDTO) {
        Wallet wallet = new Wallet();
        User user = new User();

        user.setUser_id(createWalletDTO.getUser_id());
        wallet.setWallet_id(createWalletDTO.getWallet_id());
        wallet.setName(createWalletDTO.getName());
        wallet.setAmount(createWalletDTO.getAmount());

        walletRepository.save(wallet);
    }

    @Override
    public void updateWallet(Long wallet_id, Wallet wallet) {
        Wallet wallet2 = walletRepository.findById(wallet_id).get();
        System.out.println(wallet2.toString());

        wallet2.setName(wallet.getName());
        wallet2.setAmount(wallet.getAmount());
        walletRepository.save(wallet2);
    }

    @Override
    public void deleteWallet(Long wallet_id) {
        walletRepository.deleteById(wallet_id);
    }
}
