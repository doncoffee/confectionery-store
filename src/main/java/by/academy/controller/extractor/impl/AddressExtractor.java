package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.AddressService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.impl.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddressExtractor implements Extractor<AddressDTO> {
    private final AddressService service = new AddressServiceImpl();
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
        List<AddressDTO> list = service.findAllByPage(pageNumber, itemsPerPage);
        request.setAttribute("addresses", list);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("totalItems", totalItems);
    }
}
