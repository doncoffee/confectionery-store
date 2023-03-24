package by.academy.service.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.SupplierDAOImpl;
import by.academy.entity.Supplier;
import by.academy.service.SupplierService;
import by.academy.service.dto.SupplierDTO;
import by.academy.util.Mapper;
import by.academy.util.impl.SupplierMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierServiceImpl implements SupplierService {
    private Mapper<Supplier, SupplierDTO> mapper = new SupplierMapper();
    private final DAO<Supplier> dao = new SupplierDAOImpl();

    @Override
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = dao.create(mapper.mapToEntity(supplierDTO));
        return mapper.mapToDTO(supplier);
    }

    @Override
    public List<SupplierDTO> readAllSuppliers() {
        return dao.read()
                .stream()
                .map(map ->mapper.mapToDTO(map))
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = dao.update(mapper.mapToEntity(supplierDTO));
        return mapper.mapToDTO(supplier);
    }

    @Override
    public void deleteSupplier(int id) {
        dao.delete(id);
    }

    @Override
    public SupplierDTO selectSupplierById(int id) {
        Supplier supplier = dao.selectById(id);
        return mapper.mapToDTO(supplier);
    }

    @Override
    public List<SupplierDTO> findAllByPage(Integer currentPage, Integer recordsPerPage) {
        return dao.findAllByPage(currentPage, recordsPerPage)
                .stream()
                .map(map ->mapper.mapToDTO(map))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNumberOfRows() {
        return dao.getNumberOfRows();
    }
}
