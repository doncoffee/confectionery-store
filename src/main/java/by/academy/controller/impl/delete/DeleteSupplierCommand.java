package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SupplierExtractor;
import by.academy.service.SupplierService;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.ID;
import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_SUPPLIERS_JSP;

public class DeleteSupplierCommand implements Command {
    private final SupplierService service = new SupplierServiceImpl();
    private final Extractor extractor = new SupplierExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        service.deleteSupplier(id);
        extractor.extract(request);
        return JSP_LISTS_SUPPLIERS_JSP;
    }
}
