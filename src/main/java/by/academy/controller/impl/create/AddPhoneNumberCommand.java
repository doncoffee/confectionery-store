package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddPhoneNumberCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PhoneNumberService service = new PhoneNumberServiceImpl();
        PhoneNumberDTO phoneNumber = PhoneNumberDTO.builder()
                .id(null)
                .number(request.getParameter("number"))
                .build();
        service.createPhoneNumber(phoneNumber);
        List<PhoneNumberDTO> list = service.readAllPhoneNumbers();
        request.setAttribute("phoneNumbers", list);
        return "/jsp/lists/phoneNumbers.jsp";
    }
}
