package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.PhoneNumberExtractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.JSP_ADD_ADD_PHONE_NUMBER_JSP;

public class GoToAddPhoneNumberCommand implements Command {
    private final Extractor extractor = new PhoneNumberExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return JSP_ADD_ADD_PHONE_NUMBER_JSP;
    }
}
