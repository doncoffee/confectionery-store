package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.SupplierService;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SupplierExtractor implements Extractor<SupplierDTO> {
    private final SupplierService service = new SupplierServiceImpl();
    @Override
    public void extract(HttpServletRequest request) {
        String pageNumberParam = request.getParameter("currentPage");
        String itemsPerPageParam = request.getParameter("itemsPerPage");
        int pageNumber = pageNumberParam != null ? Integer.parseInt(pageNumberParam) : 1;
        int itemsPerPage = itemsPerPageParam != null ? Integer.parseInt(itemsPerPageParam) : 3;

        int totalItems = (int) Math.ceil((double)
                service.getNumberOfRows() / itemsPerPage);

        List<SupplierDTO> list = service.findAllByPage(pageNumber, itemsPerPage);
        request.setAttribute("suppliers", list);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("totalItems", totalItems);
    }
}
