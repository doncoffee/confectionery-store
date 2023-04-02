package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.AddressExtractor;
import by.academy.service.AddressService;
import by.academy.service.impl.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static by.academy.controller.constants.ControllerConstants.ID;
import static by.academy.controller.constants.ControllerConstants.JSP_LISTS_ADDRESSES_JSP;

public class DeleteAddressCommand implements Command {
    private final AddressService service = new AddressServiceImpl();
    private final Extractor extractor = new AddressExtractor();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        service.deleteAddress(id);
        extractor.extract(request);
        return JSP_LISTS_ADDRESSES_JSP;
    }
}
