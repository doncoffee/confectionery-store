package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.ChocolateService;
import by.academy.service.dto.ChocolateDTO;
import by.academy.service.impl.ChocolateServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ChocolateExtractor implements Extractor<ChocolateDTO> {
    private final ChocolateService service = new ChocolateServiceImpl();
    @Override
    public void extract(HttpServletRequest request) {
        String pageNumberParam = request.getParameter("currentPage");
        String itemsPerPageParam = request.getParameter("itemsPerPage");
        int pageNumber = pageNumberParam != null
                ? Integer.parseInt(pageNumberParam) : 1;
        int itemsPerPage = itemsPerPageParam != null
                ? Integer.parseInt(itemsPerPageParam) : 3;

        int totalItems = (int) Math.ceil((double)
                service.getNumberOfRows() / itemsPerPage);

        List<ChocolateDTO> list = service.findAllByPage(pageNumber,
                itemsPerPage);
        request.setAttribute("chocolates", list);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("totalItems", totalItems);
    }
}
