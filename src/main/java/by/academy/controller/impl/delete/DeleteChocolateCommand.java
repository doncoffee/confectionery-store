package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.ChocolateExtractor;
import by.academy.service.ChocolateService;
import by.academy.service.impl.ChocolateServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.ID;
import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_CHOCOLATES_JSP;

public class DeleteChocolateCommand implements Command {
    private final ChocolateService service = new ChocolateServiceImpl();
    private final Extractor extractor = new ChocolateExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        service.deleteChocolate(id);
        extractor.extract(request);
        return JSP_LISTS_CHOCOLATES_JSP;
    }
}
