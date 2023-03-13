package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.service.AddressService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.impl.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddAddressCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        AddressService service = new AddressServiceImpl();
        AddressDTO address = AddressDTO.builder()
                .id(null)
                .name(request.getParameter("name"))
                .build();
        service.createAddress(address);
        List<AddressDTO> list = service.readAllAddresses();
        request.setAttribute("addresses", list);
        return "/jsp/lists/addresses.jsp";
    }
}
