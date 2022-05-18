package com.rakharafifa.miniproject.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto.AddressDto;
import com.rakharafifa.miniproject.model.entity.AddressEntity;
import com.rakharafifa.miniproject.repository.AddressRepository;
import com.rakharafifa.miniproject.service.interfaces.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressEntity> getAllAddress() {
        List<AddressEntity> addresss = new ArrayList<>();
        addressRepository.findAll().forEach(addresss::add);
        return addresss;
    }

    @Override
    public List<AddressDto> getAllAddressDto() {
        List<AddressEntity> addresss = addressRepository.findAll();
        List<AddressDto> addressDtos = new ArrayList<>();

        addresss.forEach(isi ->{
            AddressDto dto = new AddressDto();
            dto.setAddress_id(isi.getAddress_id());
            dto.setProvince(isi.getProvince());
            dto.setCity(isi.getCity());

            addressDtos.add(dto);
        });
        return addressDtos;
    }

    @Override
    public AddressEntity getAddressById(Long address_id) {
        return addressRepository.findById(address_id).get();
    }

    @Override
    public void createAddress(AddressEntity address) {
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Long address_id, AddressEntity address) {
        AddressEntity address2 = addressRepository.findById(address_id).get();
        System.out.println(address2.toString());
        address2.setProvince(address.getProvince());
        address2.setCity(address.getCity());
        address2.setPost(address.getPost());
        address2.setDetail(address.getDetail());
        addressRepository.save(address2);
    }

    @Override
    public void deleteAddress(Long address_id) {
        addressRepository.deleteById(address_id);
    }
}
