package by.academy.dao.impl;

import by.academy.dao.CookieDAO;
import by.academy.entity.Cookie;

public class CookieDAOImpl extends DAOImpl<Cookie> implements CookieDAO {
    public CookieDAOImpl() {
        super(Cookie.class);
    }
}
