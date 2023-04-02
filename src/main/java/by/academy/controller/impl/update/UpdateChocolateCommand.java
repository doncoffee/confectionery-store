package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.ChocolateExtractor;
import by.academy.service.ChocolateService;
import by.academy.service.dto.ChocolateDTO;
import by.academy.service.impl.ChocolateServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.*;

public class UpdateChocolateCommand implements Command {
    private final ChocolateService service = new ChocolateServiceImpl();
    private final Extractor extractor = new ChocolateExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int brandId = Integer.parseInt(request.getParameter(BRAND_ID));
        int storeId = Integer.parseInt(request.getParameter(STORE_ID));
        int supplierId = Integer.parseInt(request.getParameter(SUPPLIER_ID));
        ChocolateDTO chocolate = ChocolateDTO.builder()
                .id(Integer.valueOf(request.getParameter(ID)))
                .price(Double.valueOf(request.getParameter(PRICE)))
                .type(request.getParameter(TYPE))
                .weight(Double.valueOf(request.getParameter(WEIGHT)))
                .composition(request.getParameter(COMPOSITION))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        service.updateChocolate(chocolate);
        extractor.extract(request);
        return JSP_LISTS_CHOCOLATES_JSP;
    }
}
