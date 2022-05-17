package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.dto_create.CreateAddressDTO;
import com.rakharafifa.miniproject.model.dto_get.AddressDto;
import com.rakharafifa.miniproject.model.entity.Address;

public interface AddressService {
    List<Address> getAllAddress();
    List<AddressDto> getAllAddressDto();
    Address getAddressById(Long address_id);
    void createAddressDto(CreateAddressDTO createAddressDTO);
    void updateAddress(Long address_id, Address address);
    void deleteAddress(Long address_id);
}
