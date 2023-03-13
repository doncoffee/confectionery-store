package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.impl.BrandServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteBrandCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        BrandService service = new BrandServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteBrand(id);
        List<BrandDTO> list = service.readAllBrands();
        request.setAttribute("brands", list);
        return "/jsp/lists/brands.jsp";
    }
}
