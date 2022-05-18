package com.rakharafifa.miniproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rakharafifa.miniproject.model.entity.AddressEntity;
import com.rakharafifa.miniproject.repository.AddressRepository;
import com.rakharafifa.miniproject.service.implementation.AddressServiceImpl;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    private final EasyRandom EASY_RANDOM = new EasyRandom();

    @InjectMocks
    private AddressServiceImpl service;

    @Mock
    private AddressRepository repository;

    @Test
    void findAllAddress(){
        List<AddressEntity> addresss = EASY_RANDOM.objects(AddressEntity.class, 2)
        .collect(Collectors.toList());

        when(repository.findAll()).thenReturn(addresss);
        service.getAllAddress();
        verify(repository, times(1)).findAll();
    }

    @Test
    void findAddressById(){
        AddressEntity address = EASY_RANDOM.nextObject(AddressEntity.class);
        System.out.println(address);

        when(repository.findById(address.getAddress_id())).thenReturn(Optional.of(address));
        service.getAddressById(address.getAddress_id());
        verify(repository, times(1)).findById(address.getAddress_id());
    }

    // @Test
    // void createNewAddressDto(){
    //     Address address = EASY_RANDOM.nextObject(Address.class);
    //     AddressDto addressDtos = new AddressDto();

    //     when(repository.save(address)).thenReturn(address);
    //     service.createAddressDto(addressDtos);
    //     verify(repository, times(1)).save(address);
    // }

    @Test
    public void deleteAddressById(){
        AddressEntity address = EASY_RANDOM.nextObject(AddressEntity.class);

        service.deleteAddress(address.getAddress_id());
        verify(repository).deleteById(address.getAddress_id());
    }

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() {
        AddressEntity address = EASY_RANDOM.nextObject(AddressEntity.class);
        AddressEntity newAddress = new AddressEntity();
        newAddress.setProvince("Baru");

        when(repository.findById(address.getAddress_id())).thenReturn(Optional.of(address));
        service.updateAddress(address.getAddress_id(), newAddress);
        verify(repository).save(address);
        verify(repository).findById(address.getAddress_id());
    }
}
