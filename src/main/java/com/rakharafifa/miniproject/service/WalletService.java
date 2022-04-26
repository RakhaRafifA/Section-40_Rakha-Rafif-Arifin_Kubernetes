package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.entity.Wallet;

public interface WalletService {
    List<Wallet> getAllWallet();
    Wallet getWalletById(Long wallet_id);
    Wallet createWallet(Wallet wallet);
    void updateWallet(Long wallet_id, Wallet wallet);
    void deleteWallet(Long wallet_id);
}
