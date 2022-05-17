package com.rakharafifa.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto_create.CreateAddressDTO;
import com.rakharafifa.miniproject.model.dto_get.AddressDto;
import com.rakharafifa.miniproject.model.dto_get.UserDto;
import com.rakharafifa.miniproject.model.entity.Address;
import com.rakharafifa.miniproject.model.entity.User;
import com.rakharafifa.miniproject.repository.AddressRepository;

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
    public List<Address> getAllAddress() {
        List<Address> addresss = new ArrayList<>();
        addressRepository.findAll().forEach(addresss::add);
        return addresss;
    }

    @Override
    public List<AddressDto> getAllAddressDto() {
        List<Address> addresss = addressRepository.findAll();
        List<AddressDto> addressDtos = new ArrayList<>();
        for(Address address : addresss){
            AddressDto addressDto = new AddressDto();
            UserDto userDto = new UserDto();

            addressDto.setAddress_id(address.getAddress_id());
            addressDto.setProvince(address.getProvince());
            addressDto.setCity(address.getCity());
            addressDto.setUser_id(address.getUser().getUser_id());

            userDto.setUser_id(address.getUser().getUser_id());
            userDto.setName(address.getUser().getName());
            userDto.setUsername(address.getUser().getUsername());

            addressDtos.add(addressDto);
        }
        return addressDtos;
    }

    @Override
    public Address getAddressById(Long address_id) {
        return addressRepository.findById(address_id).get();
    }

    @Override
    public void createAddressDto(CreateAddressDTO createAddressDTO) {
        Address address = new Address();
        User user = new User();

        user.setUser_id(createAddressDTO.getUser_id());
        address.setAddress_id(createAddressDTO.getAddress_id());
        address.setProvince(createAddressDTO.getProvince());
        address.setCity(createAddressDTO.getProvince());
        address.setPost(createAddressDTO.getPost());
        address.setDetail(createAddressDTO.getDetail());

        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Long address_id, Address address) {
        Address address2 = addressRepository.findById(address_id).get();
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
