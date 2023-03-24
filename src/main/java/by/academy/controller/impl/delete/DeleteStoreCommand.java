package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.StoreExtractor;
import by.academy.service.StoreService;
import by.academy.service.dto.StoreDTO;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteStoreCommand implements Command {
    private final StoreService service = new StoreServiceImpl();
    private final Extractor<StoreDTO> extractor = new StoreExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteStore(id);
        extractor.extract(request);
        return "/jsp/lists/stores.jsp";
    }
}
