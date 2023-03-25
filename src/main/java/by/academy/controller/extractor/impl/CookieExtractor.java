package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.CookieService;
import by.academy.service.dto.CookieDTO;
import by.academy.service.impl.CookieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.academy.controller.constants.ControllerConstants.*;

public class CookieExtractor implements Extractor {
    private final CookieService service = new CookieServiceImpl();
    @Override
    public void extract(HttpServletRequest request) {
        String pageNumberParam = request.getParameter(CURRENT_PAGE);
        String itemsPerPageParam = request.getParameter(ITEMS_PER_PAGE);
        int pageNumber = pageNumberParam != null ? Integer.parseInt(pageNumberParam) : 1;
        int itemsPerPage = itemsPerPageParam != null ? Integer.parseInt(itemsPerPageParam) : 3;

        int totalItems = (int) Math.ceil((double)
                service.getNumberOfRows() / itemsPerPage);

        List<CookieDTO> list = service.findAllByPage(pageNumber, itemsPerPage);
        request.setAttribute(COOKIES, list);
        request.setAttribute(CURRENT_PAGE, pageNumber);
        request.setAttribute(ITEMS_PER_PAGE, itemsPerPage);
        request.setAttribute(TOTAL_ITEMS, totalItems);
    }
}
