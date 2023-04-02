package by.academy.util.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.*;
import by.academy.entity.*;
import by.academy.service.dto.StoreDTO;
import by.academy.util.Mapper;

public class StoreMapper implements Mapper<Store, StoreDTO> {
    private final DAO<Address> addressDAO = new AddressDAOImpl();
    private final DAO<PhoneNumber> phoneNumberDAO = new PhoneNumberDAOImpl();
    @Override
    public Store mapToEntity(StoreDTO object) {
        return Store.builder()
                .id(object.getId())
                .address(addressDAO.selectById(object.getAddressId()))
                .phoneNumber(phoneNumberDAO.selectById(object.getPhoneNumberId()))
                .build();
    }

    @Override
    public StoreDTO mapToDTO(Store object) {
        return StoreDTO.builder()
                .id(object.getId())
                .addressId(object.getAddress().getId())
                .addressName(object.getAddress().getName())
                .phoneNumberId(object.getPhoneNumber().getId())
                .phoneNumber(object.getPhoneNumber().getNumber())
                .build();
    }
}
