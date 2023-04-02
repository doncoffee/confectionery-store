package by.academy.service.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.CookieDAOImpl;
import by.academy.entity.Cookie;
import by.academy.service.CookieService;
import by.academy.service.dto.CookieDTO;
import by.academy.util.Mapper;
import by.academy.util.impl.CookieMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CookieServiceImpl implements CookieService {
    private final Mapper<Cookie, CookieDTO> mapper = new CookieMapper();
    private final DAO<Cookie> dao = new CookieDAOImpl();

    @Override
    public CookieDTO createCookie(CookieDTO cookieDTO) {
        Cookie cookie = dao.create(mapper.mapToEntity(cookieDTO));
        return mapper.mapToDTO(cookie);
    }

    @Override
    public List<CookieDTO> readAllCookies() {
        return dao.read()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CookieDTO updateCookie(CookieDTO cookieDTO) {
        Cookie cookie = dao.update(mapper.mapToEntity(cookieDTO));
        return mapper.mapToDTO(cookie);
    }

    @Override
    public void deleteCookie(int id) {
        dao.delete(id);
    }

    @Override
    public CookieDTO selectCookieById(int id) {
        Cookie cookie = dao.selectById(id);
        return mapper.mapToDTO(cookie);
    }

    @Override
    public List<CookieDTO> findAllByPageAndSearch(Integer currentPage, Integer recordsPerPage, String searchResult) {
        return dao.findAllByPageAndSearch(currentPage, recordsPerPage, searchResult)
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNumberOfRows(String searchResult) {
        return dao.getNumberOfRows(searchResult);
    }
}
