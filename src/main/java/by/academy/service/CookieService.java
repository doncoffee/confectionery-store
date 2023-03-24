package by.academy.service;

import by.academy.service.dto.CookieDTO;

import java.util.List;

public interface CookieService {
    CookieDTO createCookie(CookieDTO cookieDTO);

    List<CookieDTO> readAllCookies();

    CookieDTO updateCookie(CookieDTO cookieDTO);

    void deleteCookie(int id);

    CookieDTO selectCookieById(int id);

    List<CookieDTO> findAllByPage(Integer currentPage, Integer recordsPerPage);

    Integer getNumberOfRows();
}
