package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SweetsExtractor;
import by.academy.service.SweetsService;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.*;

public class UpdateSweetsCommand implements Command {
    private final SweetsService service = new SweetsServiceImpl();
    private final Extractor extractor = new SweetsExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int brandId = Integer.parseInt(request.getParameter(BRAND_ID));
        int storeId = Integer.parseInt(request.getParameter(STORE_ID));
        int supplierId = Integer.parseInt(request.getParameter(SUPPLIER_ID));
        SweetsDTO sweets = SweetsDTO.builder()
                .id(Integer.valueOf(request.getParameter(ID)))
                .price(Double.valueOf(request.getParameter(PRICE)))
                .type(request.getParameter(TYPE))
                .weight(Double.valueOf(request.getParameter(WEIGHT)))
                .composition(request.getParameter(COMPOSITION))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        service.updateSweets(sweets);
        extractor.extract(request);
        return JSP_LISTS_SWEETS_JSP;
    }
}
