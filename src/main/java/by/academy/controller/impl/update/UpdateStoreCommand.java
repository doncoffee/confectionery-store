package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.entity.Store;
import by.academy.service.AddressService;
import by.academy.service.PhoneNumberService;
import by.academy.service.StoreService;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.AddressServiceImpl;
import by.academy.service.impl.PhoneNumberServiceImpl;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UpdateStoreCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        StoreService storeService = new StoreServiceImpl();
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        int phoneNumberId = Integer.parseInt(request.getParameter("phoneNumberId"));
        StoreDTO store = StoreDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .addressId(addressId)
                .phoneNumberId(phoneNumberId)
                .build();
        storeService.updateStore(store);
        List<StoreDTO> list = storeService.readAllStores();
        request.setAttribute("stores", list);
        return "/jsp/lists/stores.jsp";
    }
}
