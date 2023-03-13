package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.service.AddressService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.impl.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteAddressCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        AddressService service = new AddressServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteAddress(id);
        List<AddressDTO> list = service.readAllAddresses();
        request.setAttribute("addresses", list);
        return "/jsp/lists/addresses.jsp";
    }
}
