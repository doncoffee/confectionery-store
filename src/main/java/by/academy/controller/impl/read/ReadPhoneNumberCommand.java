package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.PhoneNumberExtractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_PHONE_NUMBERS_JSP;

public class ReadPhoneNumberCommand implements Command {
    private final Extractor extractor = new PhoneNumberExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return JSP_LISTS_PHONE_NUMBERS_JSP;
    }
}
