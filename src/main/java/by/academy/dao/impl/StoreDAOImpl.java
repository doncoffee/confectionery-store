package by.academy.dao.impl;

import by.academy.dao.StoreDAO;
import by.academy.entity.Store;

public class StoreDAOImpl extends DAOImpl<Store> implements StoreDAO {
    public StoreDAOImpl() {
        super(Store.class);
    }
}
