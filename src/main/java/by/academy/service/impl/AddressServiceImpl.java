package by.academy.service.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.AddressDAOImpl;
import by.academy.entity.Address;
import by.academy.service.AddressService;
import by.academy.service.dto.AddressDTO;
import by.academy.util.Mapper;
import by.academy.util.impl.AddressMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AddressServiceImpl implements AddressService {
    private final Mapper<Address, AddressDTO> mapper = new AddressMapper();
    private final DAO<Address> dao = new AddressDAOImpl();
    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = dao.create(mapper.mapToEntity(addressDTO));
        return mapper.mapToDTO(address);
    }

    @Override
    public List<AddressDTO> readAllAddresses() {
        return dao.read()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO) {
        Address address = dao.update(mapper.mapToEntity(addressDTO));
        return mapper.mapToDTO(address);
    }

    @Override
    public void deleteAddress(int id) {
        dao.delete(id);
    }

    @Override
    public AddressDTO selectAddressById(int id) {
        Address address = dao.selectById(id);
        return mapper.mapToDTO(address);
    }

    @Override
    public List<AddressDTO> findAllByPageAndSearch(Integer currentPage, Integer recordsPerPage, String searchResult) {
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
