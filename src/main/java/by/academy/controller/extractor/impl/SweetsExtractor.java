package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.SweetsService;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SweetsExtractor implements Extractor<SweetsDTO> {
    private final SweetsService service = new SweetsServiceImpl();
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

        List<SweetsDTO> list = service.findAllByPage(pageNumber, itemsPerPage);
        request.setAttribute("sweets", list);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("totalItems", totalItems);
    }
}
