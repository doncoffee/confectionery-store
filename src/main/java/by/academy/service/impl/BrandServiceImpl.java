package by.academy.service.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.BrandDAOImpl;
import by.academy.entity.Brand;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.util.Mapper;
import by.academy.util.impl.BrandMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BrandServiceImpl implements BrandService {
    private final Mapper<Brand, BrandDTO> mapper = new BrandMapper();
    private final DAO<Brand> dao = new BrandDAOImpl();

    @Override
    public BrandDTO createBrand(BrandDTO brandDTO) {
        Brand brand = dao.create(mapper.mapToEntity(brandDTO));
        return mapper.mapToDTO(brand);
    }

    @Override
    public List<BrandDTO> readAllBrands() {
        return dao.read()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BrandDTO updateBrand(BrandDTO brandDTO) {
        Brand brand = dao.update(mapper.mapToEntity(brandDTO));
        return mapper.mapToDTO(brand);
    }

    @Override
    public void deleteBrand(int id) {
        dao.delete(id);
    }

    @Override
    public BrandDTO selectBrandById(int id) {
        Brand brand = dao.selectById(id);
        return mapper.mapToDTO(brand);
    }

    @Override
    public List<BrandDTO> findAllByPageAndSearch(Integer currentPage, Integer recordsPerPage, String searchResult) {
        return dao.findAllByPageAndSearch(currentPage, recordsPerPage, searchResult)
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNumberOfRows(String searchResult) {
        return dao.getNumberOfRows(searchResult);
    }
}
