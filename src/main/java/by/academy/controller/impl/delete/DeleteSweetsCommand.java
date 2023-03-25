package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.SweetsExtractor;
import by.academy.service.SweetsService;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.ID;
import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_SWEETS_JSP;

public class DeleteSweetsCommand implements Command {
    private final SweetsService service = new SweetsServiceImpl();
    private final Extractor extractor = new SweetsExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        service.deleteSweets(id);
        extractor.extract(request);
        return JSP_LISTS_SWEETS_JSP;
    }
}
