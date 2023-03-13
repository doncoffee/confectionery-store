package by.academy.dao.impl;

import by.academy.dao.ChocolateDAO;
import by.academy.entity.Chocolate;

public class ChocolateDAOImpl extends DAOImpl<Chocolate> implements ChocolateDAO {
    public ChocolateDAOImpl() {
        super(Chocolate.class);
    }
}
