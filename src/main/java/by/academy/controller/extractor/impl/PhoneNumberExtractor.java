package by.academy.controller.extractor.impl;

import by.academy.controller.extractor.Extractor;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PhoneNumberExtractor implements Extractor<PhoneNumberDTO> {
    private final PhoneNumberService service = new PhoneNumberServiceImpl();

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

        List<PhoneNumberDTO> list = service.findAllByPage(pageNumber,
                itemsPerPage);
        request.setAttribute("phoneNumbers", list);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("totalItems", totalItems);
    }
}
