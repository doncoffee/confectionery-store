package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SupplierExtractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_SUPPLIERS_JSP;

public class ReadSupplierCommand implements Command {
    private final Extractor extractor = new SupplierExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return JSP_LISTS_SUPPLIERS_JSP;
    }
}
