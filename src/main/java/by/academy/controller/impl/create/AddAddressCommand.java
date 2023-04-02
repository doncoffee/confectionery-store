package by.academy.controller.impl.create;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.AddressExtractor;
import by.academy.service.AddressService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.impl.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_ADDRESSES_JSP;
import static by.academy.controller.constants.ControllerConstants.NAME;

public class AddAddressCommand implements Command {
    private final AddressService service = new AddressServiceImpl();
    private final Extractor extractor = new AddressExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        AddressDTO address = AddressDTO.builder()
                .id(null)
                .name(request.getParameter(NAME))
                .build();
        service.createAddress(address);
        extractor.extract(request);
        return JSP_LISTS_ADDRESSES_JSP;
    }
}

