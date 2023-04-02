package by.academy.util.impl;

import by.academy.entity.Brand;
import by.academy.service.dto.BrandDTO;
import by.academy.util.Mapper;

public class BrandMapper implements Mapper<Brand, BrandDTO> {
    @Override
    public Brand mapToEntity(BrandDTO object) {
        return Brand.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }

    @Override
    public BrandDTO mapToDTO(Brand object) {
        return BrandDTO.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }
}
