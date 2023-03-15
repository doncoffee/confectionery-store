package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.service.CookieService;
import by.academy.service.dto.CookieDTO;
import by.academy.service.impl.CookieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddCookieCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        CookieService cookieService = new CookieServiceImpl();
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        CookieDTO cookie = CookieDTO.builder()
                .id(null)
                .price(Double.valueOf(request.getParameter("price")))
                .type(request.getParameter("type"))
                .weight(Double.valueOf(request.getParameter("weight")))
                .composition(request.getParameter("composition"))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        cookieService.createCookie(cookie);
        List<CookieDTO> list = cookieService.readAllCookies();
        request.setAttribute("cookies", list);
        return "/jsp/lists/cookies.jsp";
    }
}
