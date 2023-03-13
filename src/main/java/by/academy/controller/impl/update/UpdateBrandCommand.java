package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.service.BrandService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.impl.BrandServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UpdateBrandCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        BrandService service = new BrandServiceImpl();
        BrandDTO brand = BrandDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .name(request.getParameter("name"))
                .build();
        service.updateBrand(brand);
        List<BrandDTO> list = service.readAllBrands();
        request.setAttribute("brands", list);
        return "/jsp/lists/brands.jsp";
    }
}
