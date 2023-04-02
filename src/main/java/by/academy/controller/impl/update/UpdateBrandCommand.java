package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.BrandExtractor;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.impl.BrandServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.*;

public class UpdateBrandCommand implements Command {
    private final BrandService service = new BrandServiceImpl();
    private final Extractor extractor = new BrandExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        BrandDTO brand = BrandDTO.builder()
                .id(Integer.valueOf(request.getParameter(ID)))
                .name(request.getParameter(NAME))
                .build();
        service.updateBrand(brand);
        extractor.extract(request);
        return JSP_LISTS_BRANDS_JSP;
    }
}
