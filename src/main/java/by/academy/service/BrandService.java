package by.academy.service;

import by.academy.service.dto.BrandDTO;

import java.util.List;

public interface BrandService {
    BrandDTO createBrand(BrandDTO brandDTO);

    List<BrandDTO> readAllBrands();

    BrandDTO updateBrand(BrandDTO brandDTO);

    void deleteBrand(int id);

    BrandDTO selectBrandById(int id);

    List<BrandDTO> findAllByPage(Integer currentPage, Integer recordsPerPage);

    Integer getNumberOfRows();
}
