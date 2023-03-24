package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.impl.BrandServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BrandExtractor implements Extractor<BrandDTO> {
    private final BrandService service = new BrandServiceImpl();

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
        List<BrandDTO> list = service.findAllByPage(pageNumber, itemsPerPage);
        request.setAttribute("brands", list);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("totalItems", totalItems);
    }
}
