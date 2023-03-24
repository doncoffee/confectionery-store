package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.BrandExtractor;
import by.academy.service.dto.BrandDTO;

import javax.servlet.http.HttpServletRequest;

public class GoToAddBrandCommand implements Command {
    private final Extractor<BrandDTO> extractor = new BrandExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return "/jsp/add/addBrand.jsp";
    }
}
