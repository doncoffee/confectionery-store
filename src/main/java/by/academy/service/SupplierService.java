package by.academy.service;

import by.academy.service.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO createSupplier(SupplierDTO supplierDTO);

    List<SupplierDTO> readAllSuppliers();

    SupplierDTO updateSupplier(SupplierDTO supplierDTO);

    void deleteSupplier(int id);

    SupplierDTO selectSupplierById(int id);

    List<SupplierDTO> findAllByPage(Integer currentPage, Integer recordsPerPage);

    Integer getNumberOfRows();
}
