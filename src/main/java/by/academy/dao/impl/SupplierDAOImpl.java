package by.academy.dao.impl;

import by.academy.dao.SupplierDAO;
import by.academy.entity.Supplier;

public class SupplierDAOImpl extends DAOImpl<Supplier> implements SupplierDAO {
    public SupplierDAOImpl() {
        super(Supplier.class);
    }
}
