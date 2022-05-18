package com.rakharafifa.miniproject.service.interfaces;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.AddressDto;
import com.rakharafifa.miniproject.model.entity.AddressEntity;

public interface AddressService {
    List<AddressEntity> getAllAddress();
    List<AddressDto> getAllAddressDto();
    AddressEntity getAddressById(Long address_id);
    void createAddress(AddressEntity address);
    void updateAddress(Long address_id, AddressEntity address);
    void deleteAddress(Long address_id);
}
