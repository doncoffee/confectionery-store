package by.academy.dao.impl;

import by.academy.dao.AddressDAO;
import by.academy.entity.Address;

public class AddressDAOImpl extends DAOImpl<Address> implements AddressDAO {
    public AddressDAOImpl() {
        super(Address.class);
    }
}
