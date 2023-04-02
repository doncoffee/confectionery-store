package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.PhoneNumberExtractor;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.*;

public class GoToEditPhoneNumberCommand implements Command {
    private final PhoneNumberService service = new PhoneNumberServiceImpl();
    private final Extractor extractor = new PhoneNumberExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        PhoneNumberDTO phoneNumberDTO = service.selectPhoneNumberById(id);
        request.setAttribute(PHONE_NUMBER, phoneNumberDTO);
        extractor.extract(request);
        return JSP_EDIT_EDIT_PHONE_NUMBER_JSP;
    }
}
