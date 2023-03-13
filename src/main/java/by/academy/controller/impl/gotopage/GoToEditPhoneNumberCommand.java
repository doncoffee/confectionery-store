package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class GoToEditPhoneNumberCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        PhoneNumberService service = new PhoneNumberServiceImpl();
        PhoneNumberDTO phoneNumberDTO = service.selectPhoneNumberById(id);
        request.setAttribute("phoneNumber", phoneNumberDTO);
        return "/jsp/edit/editPhoneNumber.jsp";
    }
}
