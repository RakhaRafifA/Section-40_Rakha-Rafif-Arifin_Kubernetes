package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.AddressDto;
import com.rakharafifa.miniproject.model.entity.Address;

public interface AddressService {
    List<Address> getAllAddress();
    List<AddressDto> getAllAddressDto();
    Address getAddressById(Long address_id);
    void createAddressDto(AddressDto addressDto);
    void updateAddress(Long address_id, Address address);
    void deleteAddress(Long address_id);
}
