package by.academy.util.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.BrandDAOImpl;
import by.academy.dao.impl.StoreDAOImpl;
import by.academy.dao.impl.SupplierDAOImpl;
import by.academy.entity.Brand;
import by.academy.entity.Chocolate;
import by.academy.entity.Store;
import by.academy.entity.Supplier;
import by.academy.service.dto.ChocolateDTO;
import by.academy.util.Mapper;

public class ChocolateMapper implements Mapper<Chocolate, ChocolateDTO> {
    private final DAO<Brand> brandDAO = new BrandDAOImpl();
    private final DAO<Store> storeDAO = new StoreDAOImpl();
    private final DAO<Supplier> supplierDAO = new SupplierDAOImpl();
    @Override
    public Chocolate mapToEntity(ChocolateDTO object) {
        return Chocolate.builder()
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
    public ChocolateDTO mapToDTO(Chocolate object) {
        return ChocolateDTO.builder()
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
