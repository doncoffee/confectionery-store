package by.academy.controller.impl.update;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.AddressExtractor;
import by.academy.service.AddressService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.impl.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.*;

public class UpdateAddressCommand implements Command {
    private final AddressService service = new AddressServiceImpl();
    private final Extractor extractor = new AddressExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        AddressDTO address = AddressDTO.builder()
                .id(Integer.valueOf(request.getParameter(ID)))
                .name(request.getParameter(NAME))
                .build();
        service.updateAddress(address);
        extractor.extract(request);
        return JSP_LISTS_ADDRESSES_JSP;
    }
}
