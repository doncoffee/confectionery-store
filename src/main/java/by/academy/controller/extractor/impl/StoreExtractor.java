package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.StoreService;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StoreExtractor implements Extractor<StoreDTO> {
    private final StoreService service = new StoreServiceImpl();
    @Override
    public void extract(HttpServletRequest request) {
        String pageNumberParam = request.getParameter("currentPage");
        String itemsPerPageParam = request.getParameter("itemsPerPage");
        int pageNumber = pageNumberParam != null ? Integer.parseInt(pageNumberParam) : 1;
        int itemsPerPage = itemsPerPageParam != null ? Integer.parseInt(itemsPerPageParam) : 3;

        int totalItems = (int) Math.ceil((double)
                service.getNumberOfRows() / itemsPerPage);

        List<StoreDTO> list = service.findAllByPage(pageNumber, itemsPerPage);
        request.setAttribute("stores", list);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("totalItems", totalItems);
    }
}
