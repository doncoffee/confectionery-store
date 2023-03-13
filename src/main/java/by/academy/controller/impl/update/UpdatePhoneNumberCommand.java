package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.entity.PhoneNumber;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UpdatePhoneNumberCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PhoneNumberService service = new PhoneNumberServiceImpl();
        PhoneNumberDTO phoneNumber = PhoneNumberDTO.builder()
                .id(Integer.valueOf(request.getParameter("id")))
                .number(request.getParameter("number"))
                .build();
        service.updatePhoneNumber(phoneNumber);
        List<PhoneNumberDTO> list = service.readAllPhoneNumbers();
        request.setAttribute("phoneNumbers", list);
        return "/jsp/lists/phoneNumbers.jsp";
    }
}
