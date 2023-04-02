package by.academy.util.impl;

import by.academy.entity.Address;
import by.academy.service.dto.AddressDTO;
import by.academy.util.Mapper;

public class AddressMapper implements Mapper<Address, AddressDTO> {
    @Override
    public Address mapToEntity(AddressDTO object) {
        return Address.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }

    @Override
    public AddressDTO mapToDTO(Address object) {
        return AddressDTO.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }
}
