package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.SupplierService;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.academy.controller.constants.ControllerConstants.*;

public class SupplierExtractor implements Extractor {
    private final SupplierService service = new SupplierServiceImpl();

    @Override
    public void extract(HttpServletRequest request) {
        String searchResult = request.getParameter(SEARCH);
        String pageNumberParam = request.getParameter(CURRENT_PAGE);
        String itemsPerPageParam = request.getParameter(ITEMS_PER_PAGE);
        int pageNumber = pageNumberParam != null ? Integer.parseInt(pageNumberParam) : 1;
        int itemsPerPage = itemsPerPageParam != null ? Integer.parseInt(itemsPerPageParam) : 3;

        int totalItems = (int) Math.ceil((double)
                service.getNumberOfRows(searchResult) / itemsPerPage);

        List<SupplierDTO> list = service.findAllByPageAndSearch(pageNumber,
                itemsPerPage, searchResult);
        request.setAttribute(SUPPLIERS, list);
        request.setAttribute(SEARCH, searchResult);
        request.setAttribute(CURRENT_PAGE, pageNumber);
        request.setAttribute(ITEMS_PER_PAGE, itemsPerPage);
        request.setAttribute(TOTAL_ITEMS, totalItems);
    }
}
