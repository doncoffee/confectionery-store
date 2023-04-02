package by.academy.util.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.BrandDAOImpl;
import by.academy.dao.impl.StoreDAOImpl;
import by.academy.dao.impl.SupplierDAOImpl;
import by.academy.entity.*;
import by.academy.service.dto.SweetsDTO;
import by.academy.util.Mapper;

public class SweetsMapper implements Mapper<Sweets, SweetsDTO> {
    private final DAO<Brand> brandDAO = new BrandDAOImpl();
    private final DAO<Store> storeDAO = new StoreDAOImpl();
    private final DAO<Supplier> supplierDAO = new SupplierDAOImpl();
    @Override
    public Sweets mapToEntity(SweetsDTO object) {
        return Sweets.builder()
                .id(object.getId())
                .price(object.getPrice())
                .type(object.getType())
                .weight(object.getWeight())
                .composition(object.getComposition())
                .brand(brandDAO.selectById(object.getBrandId()))
                .store(storeDAO.selectById(object.getStoreId()))
                .supplier(supplierDAO.selectById(object.getSupplierId()))
                .build();
    }

    @Override
    public SweetsDTO mapToDTO(Sweets object) {
        return SweetsDTO.builder()
                .id(object.getId())
                .price(object.getPrice())
                .type(object.getType())
                .weight(object.getWeight())
                .composition(object.getComposition())
                .brandId(object.getBrand().getId())
                .brandName(object.getBrand().getName())
                .storeId(object.getStore().getId())
                .storeName(object.getStore().getAddress().getName())
                .supplierId(object.getSupplier().getId())
                .supplierName(object.getSupplier().getName())
                .build();
    }
}
