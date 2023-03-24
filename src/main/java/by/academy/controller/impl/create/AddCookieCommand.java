package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.CookieExtractor;
import by.academy.service.CookieService;
import by.academy.service.dto.CookieDTO;
import by.academy.service.impl.CookieServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class AddCookieCommand implements Command {
    private final CookieService service = new CookieServiceImpl();
    private final Extractor<CookieDTO> extractor = new CookieExtractor();
    @Override
    public String execute(HttpServletRequest request) {
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
        service.createCookie(cookie);
        extractor.extract(request);
        return "/jsp/lists/cookies.jsp";
    }
}
