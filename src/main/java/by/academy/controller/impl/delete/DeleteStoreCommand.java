package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.service.StoreService;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteStoreCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        StoreService storeService = new StoreServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        storeService.deleteStore(id);
        List<StoreDTO> list = storeService.readAllStores();
        request.setAttribute("stores", list);
        return "/jsp/lists/stores.jsp";
    }
}
