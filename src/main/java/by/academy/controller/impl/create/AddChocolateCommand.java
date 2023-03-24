package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.ChocolateExtractor;
import by.academy.service.ChocolateService;
import by.academy.service.dto.ChocolateDTO;
import by.academy.service.impl.ChocolateServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class AddChocolateCommand implements Command {
    private final ChocolateService chocolateService = new ChocolateServiceImpl();
    private final Extractor<ChocolateDTO> extractor = new ChocolateExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        ChocolateDTO chocolate = ChocolateDTO.builder()
                .id(null)
                .price(Double.valueOf(request.getParameter("price")))
                .type(request.getParameter("type"))
                .weight(Double.valueOf(request.getParameter("weight")))
                .composition(request.getParameter("composition"))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        chocolateService.createChocolate(chocolate);
        extractor.extract(request);
        return "/jsp/lists/chocolates.jsp";
    }
}
