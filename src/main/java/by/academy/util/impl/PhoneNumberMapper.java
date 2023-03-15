package by.academy.util.impl;

import by.academy.entity.PhoneNumber;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.util.Mapper;

public class PhoneNumberMapper implements Mapper<PhoneNumber, PhoneNumberDTO> {
    @Override
    public PhoneNumber mapToEntity(PhoneNumberDTO object) {
        return PhoneNumber.builder()
                .id(object.getId())
                .number(object.getNumber())
                .build();
    }

    @Override
    public PhoneNumberDTO mapToDTO(PhoneNumber object) {
        return PhoneNumberDTO.builder()
                .id(object.getId())
                .number(object.getNumber())
                .build();
    }
}
