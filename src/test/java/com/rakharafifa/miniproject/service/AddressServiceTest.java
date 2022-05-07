package com.rakharafifa.miniproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rakharafifa.miniproject.model.entity.Address;
import com.rakharafifa.miniproject.repository.AddressRepository;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    private final EasyRandom EASY_RANDOM = new EasyRandom();
    private Long id;

    @InjectMocks
    private AddressServiceImpl service;

    @Mock
    private AddressRepository repository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        id = EASY_RANDOM.nextObject(Long.class);
    }

    @Test
    void findAllAddress(){
        List<Address> addresss = EASY_RANDOM.objects(Address.class, 2)
        .collect(Collectors.toList());

        when(repository.findAll()).thenReturn(addresss);
        service.getAllAddress();
        verify(repository, times(1)).findAll();
    }

    @Test
    void findAddressById(){
        Address address = EASY_RANDOM.nextObject(Address.class);
        System.out.println(address);

        when(repository.findById(address.getAddress_id())).thenReturn(Optional.of(address));
        service.getAddressById(address.getAddress_id());
        verify(repository, times(1)).findById(address.getAddress_id());
    }

    @Test
    void createNewAddress(){
        Address address = EASY_RANDOM.nextObject(Address.class);
        System.out.println(address);

        when(repository.save(address)).thenReturn(address);
        service.createAddress(address);
        verify(repository, times(1)).save(address);
    }

    @Test
    public void deleteAddressById(){
        Address address = EASY_RANDOM.nextObject(Address.class);

        service.deleteAddress(address.getAddress_id());
        verify(repository).deleteById(address.getAddress_id());
    }

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() {
        Address address = EASY_RANDOM.nextObject(Address.class);
        Address newAddress = new Address();
        newAddress.setProvince("Baru");

        when(repository.findById(address.getAddress_id())).thenReturn(Optional.of(address));
        service.updateAddress(address.getAddress_id(), newAddress);
        verify(repository).save(address);
        verify(repository).findById(address.getAddress_id());
    }
}
