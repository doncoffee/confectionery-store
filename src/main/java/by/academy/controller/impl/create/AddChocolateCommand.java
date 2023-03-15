package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.service.BrandService;
import by.academy.service.ChocolateService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.dto.ChocolateDTO;
import by.academy.service.impl.BrandServiceImpl;
import by.academy.service.impl.ChocolateServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddChocolateCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        ChocolateService chocolateService = new ChocolateServiceImpl();
        BrandService brandService = new BrandServiceImpl();
        List<BrandDTO> brandsList = brandService.readAllBrands();
        request.setAttribute("brands", brandsList);
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        ChocolateDTO chocolate = ChocolateDTO.builder()
                .id(null)
                .price(Double.valueOf(request.getParameter("price")))
                .type(request.getParameter("type"))
                .weight(Double.valueOf(request.getParameter("weight")))
                .composition(request.getParameter("composition"))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        chocolateService.createChocolate(chocolate);
        List<ChocolateDTO> list = chocolateService.readAllChocolates();
        request.setAttribute("chocolates", list);
        return "/jsp/lists/chocolates.jsp";
    }
}
