package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.BrandExtractor;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.impl.BrandServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.*;

public class GoToEditBrandCommand implements Command {
    private final BrandService service = new BrandServiceImpl();
    private final Extractor extractor = new BrandExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        int id = Integer.parseInt(request.getParameter(ID));
        BrandDTO brandDTO = service.selectBrandById(id);
        request.setAttribute(BRAND, brandDTO);
        return JSP_EDIT_EDIT_BRAND_JSP;
    }
}
