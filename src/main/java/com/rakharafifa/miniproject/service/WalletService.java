package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.dto_create.CreateWalletDTO;
import com.rakharafifa.miniproject.model.dto_get.WalletDto;
import com.rakharafifa.miniproject.model.entity.Wallet;

public interface WalletService {
    List<Wallet> getAllWallet();
    List<WalletDto> getAllWalletDto();
    Wallet getWalletById(Long wallet_id);
    void createWalletDto(CreateWalletDTO createWalletDTO);
    void updateWallet(Long wallet_id, Wallet wallet);
    void deleteWallet(Long wallet_id);
}
