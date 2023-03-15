package by.academy.util.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.AddressDAOImpl;
import by.academy.dao.impl.PhoneNumberDAOImpl;
import by.academy.entity.Address;
import by.academy.entity.PhoneNumber;
import by.academy.entity.Supplier;
import by.academy.service.dto.SupplierDTO;
import by.academy.util.Mapper;

public class SupplierMapper implements Mapper<Supplier, SupplierDTO> {
    private final DAO<Address> addressDAO = new AddressDAOImpl();
    private final DAO<PhoneNumber> phoneNumberDAO = new PhoneNumberDAOImpl();
    @Override
    public Supplier mapToEntity(SupplierDTO object) {
        return Supplier.builder()
                .id(object.getId())
                .name(object.getName())
                .contactPerson(object.getContactPerson())
                .address(addressDAO.selectById(object.getAddressId()))
                .phoneNumber(phoneNumberDAO.selectById(object.getPhoneNumberId()))
                .build();
    }

    @Override
    public SupplierDTO mapToDTO(Supplier object) {
        return SupplierDTO.builder()
                .id(object.getId())
                .name(object.getName())
                .contactPerson(object.getContactPerson())
                .addressId(object.getAddress().getId())
                .addressName(object.getAddress().getName())
                .phoneNumberId(object.getPhoneNumber().getId())
                .phoneNumber(object.getPhoneNumber().getNumber())
                .build();
    }
}
