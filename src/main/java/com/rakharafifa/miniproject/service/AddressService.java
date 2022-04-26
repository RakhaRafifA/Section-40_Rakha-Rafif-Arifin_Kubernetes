package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.entity.Address;

public interface AddressService {
    List<Address> getAllAddress();
    Address getAddressById(Long address_id);
    Address createAddress(Address address);
    void updateAddress(Long address_id, Address address);
    void deleteAddress(Long address_id);
}
