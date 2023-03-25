package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.CookieExtractor;
import by.academy.service.CookieService;
import by.academy.service.dto.CookieDTO;
import by.academy.service.impl.CookieServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.*;

public class AddCookieCommand implements Command {
    private final CookieService service = new CookieServiceImpl();
    private final Extractor extractor = new CookieExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int brandId = Integer.parseInt(request.getParameter(BRAND_ID));
        int storeId = Integer.parseInt(request.getParameter(STORE_ID));
        int supplierId = Integer.parseInt(request.getParameter(SUPPLIER_ID));
        CookieDTO cookie = CookieDTO.builder()
                .id(null)
                .price(Double.valueOf(request.getParameter(PRICE)))
                .type(request.getParameter(TYPE))
                .weight(Double.valueOf(request.getParameter(WEIGHT)))
                .composition(request.getParameter(COMPOSITION))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        service.createCookie(cookie);
        extractor.extract(request);
        return JSP_LISTS_COOKIES_JSP;
    }
}
