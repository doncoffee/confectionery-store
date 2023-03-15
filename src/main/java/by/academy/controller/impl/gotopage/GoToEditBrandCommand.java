package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.impl.BrandServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class GoToEditBrandCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        BrandService service = new BrandServiceImpl();
        BrandDTO brandDTO = service.selectBrandById(id);
        request.setAttribute("brand", brandDTO);
        return "/jsp/edit/editBrand.jsp";
    }
}
