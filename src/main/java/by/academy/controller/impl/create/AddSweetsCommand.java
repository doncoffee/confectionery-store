package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.service.*;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddSweetsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        SweetsService sweetsService = new SweetsServiceImpl();
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        SweetsDTO sweets = SweetsDTO.builder()
                .id(null)
                .price(Double.valueOf(request.getParameter("price")))
                .type(request.getParameter("type"))
                .weight(Double.valueOf(request.getParameter("weight")))
                .composition(request.getParameter("composition"))
                .brandId(brandId)
                .storeId(storeId)
                .supplierId(supplierId)
                .build();
        sweetsService.createSweets(sweets);
        List<SweetsDTO> list = sweetsService.readAllSweets();
        request.setAttribute("sweets", list);
        return "/jsp/lists/sweets.jsp";
    }
}
