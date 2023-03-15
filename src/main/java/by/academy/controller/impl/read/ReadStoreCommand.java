package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.service.StoreService;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReadStoreCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        StoreService storeService = new StoreServiceImpl();
        List<StoreDTO> list = storeService.readAllStores();
        request.setAttribute("stores", list);
        return "/jsp/lists/stores.jsp";
    }
}
