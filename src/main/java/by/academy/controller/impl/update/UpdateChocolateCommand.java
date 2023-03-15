package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.entity.Chocolate;
import by.academy.service.BrandService;
import by.academy.service.ChocolateService;
import by.academy.service.StoreService;
import by.academy.service.SupplierService;
import by.academy.service.dto.ChocolateDTO;
import by.academy.service.impl.BrandServiceImpl;
import by.academy.service.impl.ChocolateServiceImpl;
import by.academy.service.impl.StoreServiceImpl;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UpdateChocolateCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        ChocolateService chocolateService = new ChocolateServiceImpl();
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        ChocolateDTO chocolate = ChocolateDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .price(Double.valueOf(request.getParameter("price")))
                .type(request.getParameter("type"))
                .weight(Double.valueOf(request.getParameter("weight")))
                .composition(request.getParameter("composition"))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        chocolateService.updateChocolate(chocolate);
        List<ChocolateDTO> list = chocolateService.readAllChocolates();
        request.setAttribute("chocolates", list);
        return "/jsp/lists/chocolates.jsp";
    }
}
