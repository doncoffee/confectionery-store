package by.academy.service;

import by.academy.service.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO);

    List<AddressDTO> readAllAddresses();

    AddressDTO updateAddress(AddressDTO addressDTO);

    void deleteAddress(int id);

    AddressDTO selectAddressById(int id);

    List<AddressDTO> findAllByPage(Integer currentPage, Integer recordsPerPage);

    Integer getNumberOfRows();
}
