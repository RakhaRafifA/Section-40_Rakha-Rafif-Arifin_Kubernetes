package com.rakharafifa.miniproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rakharafifa.miniproject.model.entity.WalletEntity;
import com.rakharafifa.miniproject.repository.WalletRepository;
import com.rakharafifa.miniproject.service.implementation.WalletServiceImpl;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WalletServiceTest {
    private final EasyRandom EASY_RANDOM = new EasyRandom();

    @InjectMocks
    private WalletServiceImpl service;

    @Mock
    private WalletRepository repository;

    @Test
    void findAllWallet(){
        List<WalletEntity> wallets = EASY_RANDOM.objects(WalletEntity.class, 2)
        .collect(Collectors.toList());

        when(repository.findAll()).thenReturn(wallets);
        service.getAllWallet();
        verify(repository, times(1)).findAll();
    }

    @Test
    void findWalletById(){
        WalletEntity wallet = EASY_RANDOM.nextObject(WalletEntity.class);
        System.out.println(wallet);

        when(repository.findById(wallet.getWallet_id())).thenReturn(Optional.of(wallet));
        service.getWalletById(wallet.getWallet_id());
        verify(repository, times(1)).findById(wallet.getWallet_id());
    }

    // @Test
    // void createNewWallet(){
    //     Wallet wallet = EASY_RANDOM.nextObject(Wallet.class);
    //     System.out.println(wallet);

    //     when(repository.save(wallet)).thenReturn(wallet);
    //     service.createWallet(wallet);
    //     verify(repository, times(1)).save(wallet);
    // }

    @Test
    public void deleteWalletById(){
        WalletEntity wallet = EASY_RANDOM.nextObject(WalletEntity.class);

        service.deleteWallet(wallet.getWallet_id());
        verify(repository).deleteById(wallet.getWallet_id());
    }

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() {
        WalletEntity wallet = EASY_RANDOM.nextObject(WalletEntity.class);
        WalletEntity newWallet = new WalletEntity();
        newWallet.setName("Baru");

        when(repository.findById(wallet.getWallet_id())).thenReturn(Optional.of(wallet));
        service.updateWallet(wallet.getWallet_id(), newWallet);
        verify(repository).save(wallet);
        verify(repository).findById(wallet.getWallet_id());
    }
}
