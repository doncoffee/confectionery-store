package by.academy.dao.impl;

import by.academy.dao.SweetsDAO;
import by.academy.entity.Sweets;

public class SweetsDAOImpl extends DAOImpl<Sweets> implements SweetsDAO {
    public SweetsDAOImpl() {
        super(Sweets.class);
    }
}
