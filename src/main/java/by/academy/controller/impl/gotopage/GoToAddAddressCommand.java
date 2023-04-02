package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.AddressExtractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.JSP_ADD_ADD_ADDRESS_JSP;

public class GoToAddAddressCommand implements Command {
    private final Extractor extractor = new AddressExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return JSP_ADD_ADD_ADDRESS_JSP;
    }
}
