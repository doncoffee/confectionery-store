package by.academy.dao.impl;

import by.academy.dao.PhoneNumberDAO;
import by.academy.entity.PhoneNumber;

public class PhoneNumberDAOImpl extends DAOImpl<PhoneNumber> implements PhoneNumberDAO {
    public PhoneNumberDAOImpl() {
        super(PhoneNumber.class);
    }
}
