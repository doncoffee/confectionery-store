package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.PhoneNumberExtractor;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_PHONE_NUMBERS_JSP;
import static by.academy.controller.constants.ControllerConstants.NUMBER;

public class AddPhoneNumberCommand implements Command {
    private final PhoneNumberService service = new PhoneNumberServiceImpl();
    private final Extractor extractor = new PhoneNumberExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        PhoneNumberDTO phoneNumber = PhoneNumberDTO.builder()
                .id(null)
                .number(request.getParameter(NUMBER))
                .build();
        service.createPhoneNumber(phoneNumber);
        extractor.extract(request);
        return JSP_LISTS_PHONE_NUMBERS_JSP;
    }
}
