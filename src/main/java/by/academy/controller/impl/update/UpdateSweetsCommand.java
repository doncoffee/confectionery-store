package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.entity.Cookie;
import by.academy.entity.Sweets;
import by.academy.service.BrandService;
import by.academy.service.StoreService;
import by.academy.service.SupplierService;
import by.academy.service.SweetsService;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.BrandServiceImpl;
import by.academy.service.impl.StoreServiceImpl;
import by.academy.service.impl.SupplierServiceImpl;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UpdateSweetsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        SweetsService sweetsService = new SweetsServiceImpl();
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        SweetsDTO sweets = SweetsDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .price(Double.valueOf(request.getParameter("price")))
                .type(request.getParameter("type"))
                .weight(Double.valueOf(request.getParameter("weight")))
                .composition(request.getParameter("composition"))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        sweetsService.updateSweets(sweets);
        List<SweetsDTO> list = sweetsService.readAllSweets();
        request.setAttribute("sweets", list);
        return "/jsp/lists/sweets.jsp";
    }
}
