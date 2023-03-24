package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SweetsExtractor;
import by.academy.service.SweetsService;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UpdateSweetsCommand implements Command {
    private final SweetsService service = new SweetsServiceImpl();
    private final Extractor<SweetsDTO> extractor = new SweetsExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        SweetsDTO sweets = SweetsDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .price(Double.valueOf(request.getParameter("price")))
                .type(request.getParameter("type"))
                .weight(Double.valueOf(request.getParameter("weight")))
                .composition(request.getParameter("composition"))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        service.updateSweets(sweets);
        extractor.extract(request);
        return "/jsp/lists/sweets.jsp";
    }
}
