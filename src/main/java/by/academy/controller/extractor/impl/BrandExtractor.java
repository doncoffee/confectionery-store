package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.impl.BrandServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.academy.controller.constants.ControllerConstants.*;

public class BrandExtractor implements Extractor {
    private final BrandService service = new BrandServiceImpl();

    @Override
    public void extract(HttpServletRequest request) {
        String searchResult = request.getParameter(SEARCH);
        String pageNumberParam = request.getParameter(CURRENT_PAGE);
        String itemsPerPageParam = request.getParameter(ITEMS_PER_PAGE);
        int pageNumber = pageNumberParam != null
                ? Integer.parseInt(pageNumberParam) : 1;
        int itemsPerPage = itemsPerPageParam != null
                ? Integer.parseInt(itemsPerPageParam) : 3;
        int totalItems = (int) Math.ceil((double)
                service.getNumberOfRows(searchResult) / itemsPerPage);
        List<BrandDTO> list = service.findAllByPageAndSearch(pageNumber,
                itemsPerPage, searchResult);
        request.setAttribute(BRANDS, list);
        request.setAttribute(SEARCH, searchResult);
        request.setAttribute(CURRENT_PAGE, pageNumber);
        request.setAttribute(ITEMS_PER_PAGE, itemsPerPage);
        request.setAttribute(TOTAL_ITEMS, totalItems);
    }
}
