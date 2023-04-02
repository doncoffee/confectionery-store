package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.StoreExtractor;
import by.academy.service.StoreService;
import by.academy.service.impl.StoreServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.ID;
import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_STORES_JSP;

public class DeleteStoreCommand implements Command {
    private final StoreService service = new StoreServiceImpl();
    private final Extractor extractor = new StoreExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        service.deleteStore(id);
        extractor.extract(request);
        return JSP_LISTS_STORES_JSP;
    }
}
