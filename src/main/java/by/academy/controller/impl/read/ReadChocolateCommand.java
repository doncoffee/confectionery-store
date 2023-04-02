package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.ChocolateExtractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_CHOCOLATES_JSP;

public class ReadChocolateCommand implements Command {
    private final Extractor extractor = new ChocolateExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return JSP_LISTS_CHOCOLATES_JSP;
    }

}
