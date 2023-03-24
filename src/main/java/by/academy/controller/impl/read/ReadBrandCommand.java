package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.BrandExtractor;
import by.academy.service.dto.BrandDTO;

import javax.servlet.http.HttpServletRequest;

public class ReadBrandCommand implements Command {
    private final Extractor<BrandDTO> extractor = new BrandExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return "/jsp/lists/brands.jsp";
    }
}
