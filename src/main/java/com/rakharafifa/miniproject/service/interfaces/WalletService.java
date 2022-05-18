package com.rakharafifa.miniproject.service.interfaces;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.WalletDto;
import com.rakharafifa.miniproject.model.entity.WalletEntity;

public interface WalletService {
    List<WalletEntity> getAllWallet();
    List<WalletDto> getAllWalletDto();
    WalletEntity getWalletById(Long wallet_id);
    void createWallet(WalletEntity wallet);
    void updateWallet(Long wallet_id, WalletEntity wallet);
    void deleteWallet(Long wallet_id);
}
