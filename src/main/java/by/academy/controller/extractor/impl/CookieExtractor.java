package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.CookieService;
import by.academy.service.dto.CookieDTO;
import by.academy.service.impl.CookieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CookieExtractor implements Extractor<CookieDTO> {
    private final CookieService service = new CookieServiceImpl();
    @Override
    public void extract(HttpServletRequest request) {
        String pageNumberParam = request.getParameter("currentPage");
        String itemsPerPageParam = request.getParameter("itemsPerPage");
        int pageNumber = pageNumberParam != null ? Integer.parseInt(pageNumberParam) : 1;
        int itemsPerPage = itemsPerPageParam != null ? Integer.parseInt(itemsPerPageParam) : 3;

        int totalItems = (int) Math.ceil((double)
                service.getNumberOfRows() / itemsPerPage);

        List<CookieDTO> list = service.findAllByPage(pageNumber, itemsPerPage);
        request.setAttribute("cookies", list);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("totalItems", totalItems);
    }
}
