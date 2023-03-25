package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.PhoneNumberExtractor;
import by.academy.service.PhoneNumberService;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.ID;
import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_PHONE_NUMBERS_JSP;

public class DeletePhoneNumberCommand implements Command {
    private final PhoneNumberService service = new PhoneNumberServiceImpl();
    private final Extractor extractor = new PhoneNumberExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        service.deletePhoneNumber(id);
        extractor.extract(request);
        return JSP_LISTS_PHONE_NUMBERS_JSP;
    }
}
