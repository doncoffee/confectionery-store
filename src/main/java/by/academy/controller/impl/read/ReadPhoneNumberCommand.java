package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReadPhoneNumberCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PhoneNumberService service = new PhoneNumberServiceImpl();
        List<PhoneNumberDTO> list = service.readAllPhoneNumbers();
        request.setAttribute("phoneNumbers", list);
        return "/jsp/lists/phoneNumbers.jsp";
    }
}
