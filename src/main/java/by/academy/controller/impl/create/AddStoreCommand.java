package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.service.StoreService;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddStoreCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        StoreService storeService = new StoreServiceImpl();
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        int phoneNumberId = Integer.parseInt(request.getParameter("phoneNumberId"));
        StoreDTO store = StoreDTO.builder()
                .id(null)
                .addressId(addressId)
                .phoneNumberId(phoneNumberId)
                .build();
        storeService.createStore(store);
        List<StoreDTO> list = storeService.readAllStores();
        request.setAttribute("stores", list);
        return "/jsp/lists/stores.jsp";
    }
}
