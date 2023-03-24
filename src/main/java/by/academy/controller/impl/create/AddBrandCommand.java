package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.BrandExtractor;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.impl.BrandServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class AddBrandCommand implements Command {
    private final BrandService service = new BrandServiceImpl();
    private final Extractor<BrandDTO> extractor = new BrandExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        BrandDTO brand = BrandDTO.builder()
                .id(null)
                .name(request.getParameter("name"))
                .build();
        service.createBrand(brand);
        extractor.extract(request);
        return "/jsp/lists/brands.jsp";
    }
}
