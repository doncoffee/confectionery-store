package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.BrandExtractor;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.impl.BrandServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class GoToEditBrandCommand implements Command {
    private final BrandService service = new BrandServiceImpl();
    private final Extractor<BrandDTO> extractor = new BrandExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        int id = Integer.parseInt(request.getParameter("id"));
        BrandDTO brandDTO = service.selectBrandById(id);
        request.setAttribute("brand", brandDTO);
        return "/jsp/edit/editBrand.jsp";
    }
}
