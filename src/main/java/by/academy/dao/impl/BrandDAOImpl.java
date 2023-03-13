package by.academy.dao.impl;

import by.academy.dao.BrandDAO;
import by.academy.entity.Brand;

public class BrandDAOImpl extends DAOImpl<Brand> implements BrandDAO {
    public BrandDAOImpl() {
        super(Brand.class);
    }
}
