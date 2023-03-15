package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.service.*;
import by.academy.service.dto.AddressDTO;
import by.academy.service.impl.*;

import javax.servlet.http.HttpServletRequest;

public class GoToEditAddressCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        AddressService service = new AddressServiceImpl();
        AddressDTO addressDTO = service.selectAddressById(id);
        request.setAttribute("address", addressDTO);
        return "/jsp/edit/editAddress.jsp";
    }
}
